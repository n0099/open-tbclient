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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.tbadkCore.ab;
import com.baidu.tieba.x;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private com.baidu.tieba.data.e aPV;
    private boolean aPW;
    private boolean aPX;
    private boolean aPY;
    private boolean aPZ;
    private View.OnClickListener aQa;
    private View.OnLongClickListener aQb;
    private View.OnClickListener aQc;
    private View.OnClickListener aQd;
    private View.OnClickListener aQe;
    private BannerView aQf;
    private BaseFragmentActivity mActivity;
    private int index = 0;
    private com.baidu.tieba.data.j aPQ = null;
    private com.baidu.tieba.data.o aPR = null;
    private com.baidu.tieba.data.n aPS = null;
    private int aPT = 0;
    private int aPU = 0;
    private Set<String> aMz = new HashSet();
    private View.OnClickListener aQg = new p(this);

    public Set Je() {
        return this.aMz;
    }

    public void fs(int i) {
        this.index = i;
    }

    public int getPageIndex() {
        return this.index;
    }

    public void cl(boolean z) {
        this.aPX = z;
    }

    public void cm(boolean z) {
        this.aPY = z;
    }

    public void cn(boolean z) {
        this.aPZ = z;
    }

    public o(BaseFragmentActivity baseFragmentActivity) {
        this.mActivity = null;
        this.mActivity = baseFragmentActivity;
        initPadding();
    }

    public void initPadding() {
        this.aPU = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 8.0f);
        this.aPT = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 10.0f);
    }

    public void b(com.baidu.tieba.data.j jVar) {
        this.aPQ = jVar;
    }

    public void b(com.baidu.tieba.data.o oVar) {
        this.aPR = oVar;
    }

    public void b(com.baidu.tieba.data.n nVar) {
        this.aPS = nVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int i = 0;
        if (this.aPQ == null) {
            return 0;
        }
        if (this.aPQ.CN() != null && (size = this.aPQ.CN().size()) > 0) {
            i = size > 500 ? 250 : (size + 1) / 2;
        }
        int ft = ft(this.index);
        if (ft > 0) {
            ft++;
        }
        if (this.aPZ && this.aPY) {
            i += ft;
        }
        if (this.aPW) {
            i++;
        }
        return this.aPX ? i + 1 : i;
    }

    public int yH() {
        int size;
        if (this.aPQ == null || this.aPQ.CN() == null || (size = this.aPQ.CN().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int JA() {
        int size;
        if (this.aPS == null || this.aPS.CR() == null || (size = this.aPS.CR().size()) <= 0) {
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
        if (this.aPW) {
            i--;
        }
        if (this.aPX) {
            i--;
        }
        int yH = (i - 1) - ((yH() + 1) / 2);
        if (yH >= 0) {
            new com.baidu.tieba.data.m();
            return this.aPS.CR().get((this.index * 3) + yH);
        }
        return null;
    }

    public int ft(int i) {
        int JB;
        int size;
        if (i < 0 || i > JB() || !this.aPZ || !this.aPY || (JB = JB()) <= 0) {
            return 0;
        }
        if (i >= JB) {
            i = JB - 1;
            this.index = i;
        }
        if (i < JB - 1) {
            return 3;
        }
        if (this.aPS == null || this.aPS.CR() == null || (size = this.aPS.CR().size()) <= 0) {
            return 0;
        }
        return size - (i * 3);
    }

    public int JB() {
        int size;
        if (!this.aPZ || !this.aPY || this.aPS == null || this.aPS.CR() == null || (size = this.aPS.CR().size()) <= 0) {
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
        int ft = ft(this.index);
        if (this.aPW && i == 0) {
            return 2;
        }
        if (this.aPX) {
            if (this.aPW && i == 1) {
                return 1;
            }
            if (!this.aPW && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - ft) - 1) {
            return 0;
        }
        if (i == (getCount() - ft) - 1) {
            return (ft > 0 && this.aPZ && this.aPY) ? 4 : 0;
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
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.home_like_guide, null);
            if (yH() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.aQg);
            applyNightMode(view);
        } else if (itemViewType == 2) {
            if (this.aQf == null) {
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.home_like_item_banner, null);
                this.aQf = (BannerView) view.findViewById(com.baidu.tieba.w.home_like_banner_view);
            }
            this.aQf.ag("enter_bar_bck", "");
            this.aQf.setBannerType("enterforum_banner");
            if (this.aPV.Cx() != null && this.aPV.Cx().nk() != null && !this.aPV.Cx().nk().isEmpty() && this.aPV.Cx().nk().get(0).mI() != "" && this.aPV.Cx().nk().get(0).mI() != null && this.aPV.Cx().nk().get(0).getLink() != null) {
                this.aQf.a(this.mActivity.getPageContext(), this.aPV.Cx().nk().get(0).mI(), this.aPV.Cx().nk().get(0).getLink());
                if (this.aPV.Cx().nk().get(0).getLink().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
                }
            }
        } else if (itemViewType == 0) {
            if (this.aPW) {
                i--;
            }
            if (this.aPX) {
                i--;
            }
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (view == null) {
                view = a((u) null);
            }
            u uVar = 0 == 0 ? (u) view.getTag() : null;
            if (uVar != null && this.aPQ != null && this.aPQ.CN() != null) {
                this.mActivity.getLayoutMode().ab(skinType == 1);
                this.mActivity.getLayoutMode().h(view);
                a(skinType, uVar);
                uVar.aQu.setPadding(this.aPT, this.aPU, this.aPT, 0);
                if (i >= 0) {
                    if (i * 2 < this.aPQ.CN().size()) {
                        a(this.aPQ.CN().get(i * 2), uVar);
                    }
                    if ((i * 2) + 1 < this.aPQ.CN().size()) {
                        uVar.aQz.aQv.setVisibility(0);
                        a(this.aPQ.CN().get((i * 2) + 1), uVar.aQz);
                    } else {
                        uVar.aQz.aQv.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_recommendinfo_notice, null);
            if (JA() > 0 && this.aPY && this.aPY) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.findViewById(com.baidu.tieba.w.iv_dismiss).setOnClickListener(this.aQc);
            if (JB() == 1) {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(8);
            } else {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(0);
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setOnClickListener(this.aQc);
            }
            applyNightMode(view);
        } else if (itemViewType == 3) {
            if (view == null) {
                view = a((v) null);
            }
            applyNightMode(view);
            v vVar = 0 == 0 ? (v) view.getTag() : null;
            if (vVar != null) {
                this.aPS.CR();
            }
            com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) getItem(i);
            a(mVar, vVar);
            String valueOf = String.valueOf(mVar.getForumId());
            if (this.aMz.add(valueOf)) {
                TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND, "show", 1, "dev_id", valueOf);
            }
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.mActivity.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
    }

    private View a(u uVar) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.home_like_item, null);
        u uVar2 = new u();
        uVar2.aQu = (LinearLayout) inflate;
        uVar2.aQy = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign1);
        uVar2.aQv = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_left);
        uVar2.aQv.setOnClickListener(this.aQa);
        uVar2.aQv.setOnLongClickListener(this.aQb);
        uVar2.aQw = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum1);
        uVar2.aQx = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade1);
        uVar2.aQz = new u();
        uVar2.aQz.aQy = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign2);
        uVar2.aQz.aQv = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_right);
        uVar2.aQz.aQv.setOnClickListener(this.aQa);
        uVar2.aQz.aQv.setOnLongClickListener(this.aQb);
        uVar2.aQz.aQw = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum2);
        uVar2.aQz.aQx = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade2);
        inflate.setTag(uVar2);
        return inflate;
    }

    private View a(v vVar) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_recommendinfo_item, null);
        v vVar2 = new v();
        vVar2.aQA = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.view_root);
        vVar2.aQB = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.forum_view_root);
        vVar2.aQB.setOnClickListener(this.aQd);
        vVar2.aQw = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_name);
        vVar2.aQD = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_follows_count);
        vVar2.aQE = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_thread_count);
        vVar2.aQF = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_intro);
        vVar2.aQC = (BarImageView) inflate.findViewById(com.baidu.tieba.w.forum_avatar);
        vVar2.aQH = (TextView) inflate.findViewById(com.baidu.tieba.w.tv_add_love);
        vVar2.aQG = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.add_love_ll);
        vVar2.aQG.setOnClickListener(this.aQe);
        inflate.setTag(vVar2);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, u uVar) {
        if (uVar != null && uVar.cj(i)) {
            bc.i(uVar.aQv, com.baidu.tieba.v.home_like_item_bg);
            bc.i(uVar.aQz.aQv, com.baidu.tieba.v.home_like_item_bg);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.aQa = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aQc = onClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aQd = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.aQe = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.aQb = onLongClickListener;
    }

    private void a(ab abVar, u uVar) {
        if (abVar != null && uVar != null) {
            int level = abVar.getLevel();
            uVar.aQv.setTag(abVar);
            uVar.aQw.setText(abVar.getName());
            if (abVar.aeZ() == 0) {
                uVar.aQy.setVisibility(8);
            } else {
                uVar.aQy.setVisibility(0);
            }
            if (level == 0) {
                uVar.aQx.setVisibility(4);
                return;
            }
            uVar.aQx.setVisibility(0);
            bc.i((View) uVar.aQx, com.baidu.tbadk.core.util.d.bP(level));
            uVar.aQx.setText(String.valueOf(abVar.getLevel()));
        }
    }

    private void a(com.baidu.tieba.data.m mVar, v vVar) {
        if (mVar != null && vVar != null) {
            vVar.aQB.setTag(mVar);
            vVar.aQw.setText(mVar.getForumName());
            vVar.aQD.setText(fu(mVar.CP()));
            vVar.aQE.setText(fu(mVar.CQ()));
            vVar.aQF.setText(mVar.getSlogan());
            vVar.aQG.setTag(mVar);
            vVar.aQH.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_jinba_add), (Drawable) null, (Drawable) null, (Drawable) null);
            if (!TextUtils.isEmpty(mVar.getAvatar())) {
                vVar.aQC.d(mVar.getAvatar(), 10, false);
            }
        }
    }

    private String fu(int i) {
        if (i <= 9999999) {
            return String.valueOf(i);
        }
        return String.valueOf(String.format("%.1f", Float.valueOf(i / 10000.0f))) + "w";
    }

    public com.baidu.tieba.data.e JC() {
        return this.aPV;
    }

    public void a(com.baidu.tieba.data.e eVar) {
        this.aPV = eVar;
        if (this.aQf != null) {
            this.aQf.reset();
        }
        if (eVar.Cx() != null && eVar.Cx().nk() != null && !eVar.Cx().nk().isEmpty() && this.aPV.Cx().nk().get(0).mI() != "" && this.aPV.Cx().nk().get(0).mI() != null && this.aPV.Cx().nk().get(0).getLink() != null) {
            this.aPW = true;
        } else {
            this.aPW = false;
        }
        b(eVar.Cy());
        b(eVar.Cz());
        b(eVar.Cw());
        notifyDataSetChanged();
    }
}
