package com.baidu.tieba.home;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.tbadkCore.ab;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class p extends BaseAdapter {
    private com.baidu.tieba.data.e aON;
    private boolean aOO;
    private boolean aOP;
    private boolean aOQ;
    private boolean aOR;
    private View.OnClickListener aOS;
    private View.OnLongClickListener aOT;
    private View.OnClickListener aOU;
    private View.OnClickListener aOV;
    private View.OnClickListener aOW;
    private BannerView aOX;
    private BaseFragmentActivity mActivity;
    private int index = 0;
    private com.baidu.tieba.data.j aOI = null;
    private com.baidu.tieba.data.o aOJ = null;
    private com.baidu.tieba.data.n aOK = null;
    private int aOL = 0;
    private int aOM = 0;
    private Set<String> aLr = new HashSet();
    private View.OnClickListener aOY = new q(this);

    public Set IL() {
        return this.aLr;
    }

    public void fn(int i) {
        this.index = i;
    }

    public int getPageIndex() {
        return this.index;
    }

    public void ci(boolean z) {
        this.aOP = z;
    }

    public void cj(boolean z) {
        this.aOQ = z;
    }

    public void ck(boolean z) {
        this.aOR = z;
    }

    public p(BaseFragmentActivity baseFragmentActivity) {
        this.mActivity = null;
        this.mActivity = baseFragmentActivity;
        initPadding();
    }

    public void initPadding() {
        this.aOM = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 8.0f);
        this.aOL = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 10.0f);
    }

    public void b(com.baidu.tieba.data.j jVar) {
        this.aOI = jVar;
    }

    public void b(com.baidu.tieba.data.o oVar) {
        this.aOJ = oVar;
    }

    public void b(com.baidu.tieba.data.n nVar) {
        this.aOK = nVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int i = 0;
        if (this.aOI == null) {
            return 0;
        }
        if (this.aOI.Cu() != null && (size = this.aOI.Cu().size()) > 0) {
            i = size > 500 ? 250 : (size + 1) / 2;
        }
        int fo = fo(this.index);
        if (fo > 0) {
            fo++;
        }
        if (this.aOR && this.aOQ) {
            i += fo;
        }
        if (this.aOO) {
            i++;
        }
        return this.aOP ? i + 1 : i;
    }

    public int yx() {
        int size;
        if (this.aOI.Cu() == null || (size = this.aOI.Cu().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int Ji() {
        int size;
        if (this.aOK == null || this.aOK.Cy() == null || (size = this.aOK.Cy().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1 || itemViewType == 2 || itemViewType == 0 || itemViewType == 4 || itemViewType != 3) {
            return null;
        }
        if (this.aOO) {
            i--;
        }
        if (this.aOP) {
            i--;
        }
        int yx = (i - 1) - ((yx() + 1) / 2);
        if (yx >= 0) {
            new com.baidu.tieba.data.m();
            return this.aOK.Cy().get((this.index * 3) + yx);
        }
        return null;
    }

    public int fo(int i) {
        int Jj;
        int size;
        if (i < 0 || i > Jj() || !this.aOR || !this.aOQ || (Jj = Jj()) <= 0) {
            return 0;
        }
        if (i < Jj - 1) {
            return 3;
        }
        if (this.aOK == null || this.aOK.Cy() == null || (size = this.aOK.Cy().size()) <= 0) {
            return 0;
        }
        return size - (i * 3);
    }

    public int Jj() {
        int size;
        if (!this.aOR || !this.aOQ || this.aOK == null || this.aOK.Cy() == null || (size = this.aOK.Cy().size()) <= 0) {
            return 0;
        }
        int i = size / 3;
        if (size % 3 > 0) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int fo = fo(this.index);
        if (this.aOO && i == 0) {
            return 2;
        }
        if (this.aOP) {
            if (this.aOO && i == 1) {
                return 1;
            }
            if (!this.aOO && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - fo) - 1) {
            return 0;
        }
        if (i == (getCount() - fo) - 1) {
            return (fo > 0 && this.aOR && this.aOQ) ? 4 : 0;
        }
        return 3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 5;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.home_like_guide, null);
            if (yx() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.aOY);
            applyNightMode(view);
        } else if (itemViewType == 2) {
            if (this.aOX == null) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.home_like_item_banner, null);
                this.aOX = (BannerView) view.findViewById(com.baidu.tieba.w.home_like_banner_view);
            }
            this.aOX.ad("enter_bar_bck", "");
            this.aOX.setBannerType("enterforum_banner");
            if (this.aON.Cd() != null && this.aON.Cd().np() != null && !this.aON.Cd().np().isEmpty() && this.aON.Cd().np().get(0).mN() != "" && this.aON.Cd().np().get(0).mN() != null && this.aON.Cd().np().get(0).getLink() != null) {
                this.aOX.a(this.mActivity.getPageContext(), this.aON.Cd().np().get(0).mN(), this.aON.Cd().np().get(0).getLink());
                if (this.aON.Cd().np().get(0).getLink().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
                }
            }
        } else if (itemViewType == 0) {
            if (this.aOO) {
                i--;
            }
            if (this.aOP) {
                i--;
            }
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (view == null) {
                view = a((v) null);
            }
            v vVar = 0 == 0 ? (v) view.getTag() : null;
            if (vVar != null && this.aOI != null && this.aOI.Cu() != null) {
                this.mActivity.getLayoutMode().ab(skinType == 1);
                this.mActivity.getLayoutMode().h(view);
                a(skinType, vVar);
                vVar.aPq.setPadding(this.aOL, this.aOM, this.aOL, 0);
                if (i >= 0) {
                    if (i * 2 < this.aOI.Cu().size()) {
                        a(this.aOI.Cu().get(i * 2), vVar);
                    }
                    if ((i * 2) + 1 < this.aOI.Cu().size()) {
                        vVar.aPv.aPr.setVisibility(0);
                        a(this.aOI.Cu().get((i * 2) + 1), vVar.aPv);
                    } else {
                        vVar.aPv.aPr.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.enter_forum_recommendinfo_notice, null);
            if (Ji() > 0 && this.aOQ && this.aOQ) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.findViewById(com.baidu.tieba.w.iv_dismiss).setOnClickListener(this.aOU);
            if (Jj() == 1) {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(8);
            } else {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(0);
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setOnClickListener(this.aOU);
            }
            applyNightMode(view);
        } else if (itemViewType == 3) {
            if (view == null) {
                view = a((w) null);
            }
            applyNightMode(view);
            w wVar = 0 == 0 ? (w) view.getTag() : null;
            if (wVar != null) {
                this.aOK.Cy();
            }
            com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) getItem(i);
            a(mVar, wVar);
            String valueOf = String.valueOf(mVar.getForumId());
            if (this.aLr.add(valueOf)) {
                TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND, "show", 1, "dev_id", valueOf);
            }
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
    }

    private View a(v vVar) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.home_like_item, null);
        v vVar2 = new v();
        vVar2.aPq = (LinearLayout) inflate;
        vVar2.aPu = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign1);
        vVar2.aPr = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_left);
        vVar2.aPr.setOnClickListener(this.aOS);
        vVar2.aPr.setOnLongClickListener(this.aOT);
        vVar2.aPs = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum1);
        vVar2.aPt = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade1);
        vVar2.aPv = new v();
        vVar2.aPv.aPu = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign2);
        vVar2.aPv.aPr = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_right);
        vVar2.aPv.aPr.setOnClickListener(this.aOS);
        vVar2.aPv.aPr.setOnLongClickListener(this.aOT);
        vVar2.aPv.aPs = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum2);
        vVar2.aPv.aPt = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade2);
        inflate.setTag(vVar2);
        return inflate;
    }

    private View a(w wVar) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), com.baidu.tieba.x.enter_forum_recommendinfo_item, null);
        w wVar2 = new w();
        wVar2.aPw = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.view_root);
        wVar2.aPx = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.forum_view_root);
        wVar2.aPx.setOnClickListener(this.aOV);
        wVar2.aPs = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_name);
        wVar2.aPz = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_follows_count);
        wVar2.aPA = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_thread_count);
        wVar2.aPB = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_intro);
        wVar2.aPy = (BarImageView) inflate.findViewById(com.baidu.tieba.w.forum_avatar);
        wVar2.aPD = (TextView) inflate.findViewById(com.baidu.tieba.w.tv_add_love);
        wVar2.aPC = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.add_love_ll);
        wVar2.aPC.setOnClickListener(this.aOW);
        inflate.setTag(wVar2);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, v vVar) {
        if (vVar != null && vVar.cc(i)) {
            ax.i(vVar.aPr, com.baidu.tieba.v.home_like_item_bg);
            ax.i(vVar.aPv.aPr, com.baidu.tieba.v.home_like_item_bg);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.aOS = onClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.aOU = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aOV = onClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aOW = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.aOT = onLongClickListener;
    }

    private void a(ab abVar, v vVar) {
        if (abVar != null && vVar != null) {
            int level = abVar.getLevel();
            vVar.aPr.setTag(abVar);
            vVar.aPs.setText(abVar.getName());
            if (abVar.aeA() == 0) {
                vVar.aPu.setVisibility(8);
            } else {
                vVar.aPu.setVisibility(0);
            }
            if (level == 0) {
                vVar.aPt.setVisibility(4);
                return;
            }
            vVar.aPt.setVisibility(0);
            ax.i((View) vVar.aPt, com.baidu.tbadk.core.util.d.bK(level));
            vVar.aPt.setText(String.valueOf(abVar.getLevel()));
        }
    }

    private void a(com.baidu.tieba.data.m mVar, w wVar) {
        if (mVar != null && wVar != null) {
            wVar.aPx.setTag(mVar);
            wVar.aPs.setText(mVar.getForumName());
            wVar.aPz.setText(fp(mVar.Cw()));
            wVar.aPA.setText(fp(mVar.Cx()));
            wVar.aPB.setText(mVar.getSlogan());
            wVar.aPC.setTag(mVar);
            wVar.aPD.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_jinba_add), (Drawable) null, (Drawable) null, (Drawable) null);
            if (!TextUtils.isEmpty(mVar.getAvatar())) {
                wVar.aPy.d(mVar.getAvatar(), 10, false);
            }
        }
    }

    private String fp(int i) {
        if (i <= 9999999) {
            return String.valueOf(i);
        }
        return String.valueOf(String.format("%.1f", Float.valueOf(i / 10000.0f))) + "w";
    }

    public void a(com.baidu.tieba.data.e eVar) {
        this.aON = eVar;
        if (this.aOX != null) {
            this.aOX.reset();
        }
        if (eVar.Cd() != null && eVar.Cd().np() != null && !eVar.Cd().np().isEmpty() && this.aON.Cd().np().get(0).mN() != "" && this.aON.Cd().np().get(0).mN() != null && this.aON.Cd().np().get(0).getLink() != null) {
            this.aOO = true;
        } else {
            this.aOO = false;
        }
        b(eVar.Ce());
        b(eVar.Cf());
        b(eVar.Cc());
        notifyDataSetChanged();
    }
}
