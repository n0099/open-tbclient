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
    private com.baidu.tieba.data.e aPW;
    private boolean aPX;
    private boolean aPY;
    private boolean aPZ;
    private boolean aQa;
    private View.OnClickListener aQb;
    private View.OnLongClickListener aQc;
    private View.OnClickListener aQd;
    private View.OnClickListener aQe;
    private View.OnClickListener aQf;
    private BannerView aQg;
    private BaseFragmentActivity mActivity;
    private int index = 0;
    private com.baidu.tieba.data.j aPR = null;
    private com.baidu.tieba.data.o aPS = null;
    private com.baidu.tieba.data.n aPT = null;
    private int aPU = 0;
    private int aPV = 0;
    private Set<String> aMA = new HashSet();
    private View.OnClickListener aQh = new p(this);

    public Set Jj() {
        return this.aMA;
    }

    public void fs(int i) {
        this.index = i;
    }

    public int getPageIndex() {
        return this.index;
    }

    public void cl(boolean z) {
        this.aPY = z;
    }

    public void cm(boolean z) {
        this.aPZ = z;
    }

    public void cn(boolean z) {
        this.aQa = z;
    }

    public o(BaseFragmentActivity baseFragmentActivity) {
        this.mActivity = null;
        this.mActivity = baseFragmentActivity;
        initPadding();
    }

    public void initPadding() {
        this.aPV = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 8.0f);
        this.aPU = com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 10.0f);
    }

    public void b(com.baidu.tieba.data.j jVar) {
        this.aPR = jVar;
    }

    public void b(com.baidu.tieba.data.o oVar) {
        this.aPS = oVar;
    }

    public void b(com.baidu.tieba.data.n nVar) {
        this.aPT = nVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int i = 0;
        if (this.aPR == null) {
            return 0;
        }
        if (this.aPR.CT() != null && (size = this.aPR.CT().size()) > 0) {
            i = size > 500 ? 250 : (size + 1) / 2;
        }
        int ft = ft(this.index);
        if (ft > 0) {
            ft++;
        }
        if (this.aQa && this.aPZ) {
            i += ft;
        }
        if (this.aPX) {
            i++;
        }
        return this.aPY ? i + 1 : i;
    }

    public int yN() {
        int size;
        if (this.aPR == null || this.aPR.CT() == null || (size = this.aPR.CT().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int JF() {
        int size;
        if (this.aPT == null || this.aPT.CX() == null || (size = this.aPT.CX().size()) <= 0) {
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
        if (this.aPX) {
            i--;
        }
        if (this.aPY) {
            i--;
        }
        int yN = (i - 1) - ((yN() + 1) / 2);
        if (yN >= 0) {
            new com.baidu.tieba.data.m();
            return this.aPT.CX().get((this.index * 3) + yN);
        }
        return null;
    }

    public int ft(int i) {
        int JG;
        int size;
        if (i < 0 || i > JG() || !this.aQa || !this.aPZ || (JG = JG()) <= 0) {
            return 0;
        }
        if (i >= JG) {
            i = JG - 1;
            this.index = i;
        }
        if (i < JG - 1) {
            return 3;
        }
        if (this.aPT == null || this.aPT.CX() == null || (size = this.aPT.CX().size()) <= 0) {
            return 0;
        }
        return size - (i * 3);
    }

    public int JG() {
        int size;
        if (!this.aQa || !this.aPZ || this.aPT == null || this.aPT.CX() == null || (size = this.aPT.CX().size()) <= 0) {
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
        if (this.aPX && i == 0) {
            return 2;
        }
        if (this.aPY) {
            if (this.aPX && i == 1) {
                return 1;
            }
            if (!this.aPX && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - ft) - 1) {
            return 0;
        }
        if (i == (getCount() - ft) - 1) {
            return (ft > 0 && this.aQa && this.aPZ) ? 4 : 0;
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
            if (yN() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.aQh);
            applyNightMode(view);
        } else if (itemViewType == 2) {
            if (this.aQg == null) {
                view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.home_like_item_banner, null);
                this.aQg = (BannerView) view.findViewById(com.baidu.tieba.w.home_like_banner_view);
            }
            this.aQg.ag("enter_bar_bck", "");
            this.aQg.setBannerType("enterforum_banner");
            if (this.aPW.CD() != null && this.aPW.CD().nr() != null && !this.aPW.CD().nr().isEmpty() && this.aPW.CD().nr().get(0).mP() != "" && this.aPW.CD().nr().get(0).mP() != null && this.aPW.CD().nr().get(0).getLink() != null) {
                this.aQg.a(this.mActivity.getPageContext(), this.aPW.CD().nr().get(0).mP(), this.aPW.CD().nr().get(0).getLink());
                if (this.aPW.CD().nr().get(0).getLink().startsWith("game:detail:")) {
                    TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000401");
                }
            }
        } else if (itemViewType == 0) {
            if (this.aPX) {
                i--;
            }
            if (this.aPY) {
                i--;
            }
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (view == null) {
                view = a((u) null);
            }
            u uVar = 0 == 0 ? (u) view.getTag() : null;
            if (uVar != null && this.aPR != null && this.aPR.CT() != null) {
                this.mActivity.getLayoutMode().ab(skinType == 1);
                this.mActivity.getLayoutMode().h(view);
                a(skinType, uVar);
                uVar.aQv.setPadding(this.aPU, this.aPV, this.aPU, 0);
                if (i >= 0) {
                    if (i * 2 < this.aPR.CT().size()) {
                        a(this.aPR.CT().get(i * 2), uVar);
                    }
                    if ((i * 2) + 1 < this.aPR.CT().size()) {
                        uVar.aQA.aQw.setVisibility(0);
                        a(this.aPR.CT().get((i * 2) + 1), uVar.aQA);
                    } else {
                        uVar.aQA.aQw.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_recommendinfo_notice, null);
            if (JF() > 0 && this.aPZ && this.aPZ) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.findViewById(com.baidu.tieba.w.iv_dismiss).setOnClickListener(this.aQd);
            if (JG() == 1) {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(8);
            } else {
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setVisibility(0);
                view.findViewById(com.baidu.tieba.w.enterforum_forumrecommendinfo_change).setOnClickListener(this.aQd);
            }
            applyNightMode(view);
        } else if (itemViewType == 3) {
            if (view == null) {
                view = a((v) null);
            }
            applyNightMode(view);
            v vVar = 0 == 0 ? (v) view.getTag() : null;
            if (vVar != null) {
                this.aPT.CX();
            }
            com.baidu.tieba.data.m mVar = (com.baidu.tieba.data.m) getItem(i);
            a(mVar, vVar);
            String valueOf = String.valueOf(mVar.getForumId());
            if (this.aMA.add(valueOf)) {
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
        uVar2.aQv = (LinearLayout) inflate;
        uVar2.aQz = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign1);
        uVar2.aQw = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_left);
        uVar2.aQw.setOnClickListener(this.aQb);
        uVar2.aQw.setOnLongClickListener(this.aQc);
        uVar2.aQx = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum1);
        uVar2.aQy = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade1);
        uVar2.aQA = new u();
        uVar2.aQA.aQz = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_icon_sign2);
        uVar2.aQA.aQw = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.item_right);
        uVar2.aQA.aQw.setOnClickListener(this.aQb);
        uVar2.aQA.aQw.setOnLongClickListener(this.aQc);
        uVar2.aQA.aQx = (TextView) inflate.findViewById(com.baidu.tieba.w.home_lv_like_forum2);
        uVar2.aQA.aQy = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_lv_like_grade2);
        inflate.setTag(uVar2);
        return inflate;
    }

    private View a(v vVar) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.enter_forum_recommendinfo_item, null);
        v vVar2 = new v();
        vVar2.aQB = (RelativeLayout) inflate.findViewById(com.baidu.tieba.w.view_root);
        vVar2.aQC = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.forum_view_root);
        vVar2.aQC.setOnClickListener(this.aQe);
        vVar2.aQx = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_name);
        vVar2.aQE = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_follows_count);
        vVar2.aQF = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_thread_count);
        vVar2.aQG = (TextView) inflate.findViewById(com.baidu.tieba.w.forum_intro);
        vVar2.aQD = (BarImageView) inflate.findViewById(com.baidu.tieba.w.forum_avatar);
        vVar2.aQI = (TextView) inflate.findViewById(com.baidu.tieba.w.tv_add_love);
        vVar2.aQH = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.add_love_ll);
        vVar2.aQH.setOnClickListener(this.aQf);
        inflate.setTag(vVar2);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, u uVar) {
        if (uVar != null && uVar.cj(i)) {
            bc.i(uVar.aQw, com.baidu.tieba.v.home_like_item_bg);
            bc.i(uVar.aQA.aQw, com.baidu.tieba.v.home_like_item_bg);
        }
    }

    public void s(View.OnClickListener onClickListener) {
        this.aQb = onClickListener;
    }

    public void t(View.OnClickListener onClickListener) {
        this.aQd = onClickListener;
    }

    public void u(View.OnClickListener onClickListener) {
        this.aQe = onClickListener;
    }

    public void v(View.OnClickListener onClickListener) {
        this.aQf = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.aQc = onLongClickListener;
    }

    private void a(ab abVar, u uVar) {
        if (abVar != null && uVar != null) {
            int level = abVar.getLevel();
            uVar.aQw.setTag(abVar);
            uVar.aQx.setText(abVar.getName());
            if (abVar.afe() == 0) {
                uVar.aQz.setVisibility(8);
            } else {
                uVar.aQz.setVisibility(0);
            }
            if (level == 0) {
                uVar.aQy.setVisibility(4);
                return;
            }
            uVar.aQy.setVisibility(0);
            bc.i((View) uVar.aQy, com.baidu.tbadk.core.util.d.bP(level));
            uVar.aQy.setText(String.valueOf(abVar.getLevel()));
        }
    }

    private void a(com.baidu.tieba.data.m mVar, v vVar) {
        if (mVar != null && vVar != null) {
            vVar.aQC.setTag(mVar);
            vVar.aQx.setText(mVar.getForumName());
            vVar.aQE.setText(fu(mVar.CV()));
            vVar.aQF.setText(fu(mVar.CW()));
            vVar.aQG.setText(mVar.getSlogan());
            vVar.aQH.setTag(mVar);
            vVar.aQI.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_jinba_add), (Drawable) null, (Drawable) null, (Drawable) null);
            if (!TextUtils.isEmpty(mVar.getAvatar())) {
                vVar.aQD.d(mVar.getAvatar(), 10, false);
            }
        }
    }

    private String fu(int i) {
        if (i <= 9999999) {
            return String.valueOf(i);
        }
        return String.valueOf(String.format("%.1f", Float.valueOf(i / 10000.0f))) + "w";
    }

    public com.baidu.tieba.data.e JH() {
        return this.aPW;
    }

    public void a(com.baidu.tieba.data.e eVar) {
        this.aPW = eVar;
        if (this.aQg != null) {
            this.aQg.reset();
        }
        if (eVar.CD() != null && eVar.CD().nr() != null && !eVar.CD().nr().isEmpty() && this.aPW.CD().nr().get(0).mP() != "" && this.aPW.CD().nr().get(0).mP() != null && this.aPW.CD().nr().get(0).getLink() != null) {
            this.aPX = true;
        } else {
            this.aPX = false;
        }
        b(eVar.CE());
        b(eVar.CF());
        b(eVar.CC());
        notifyDataSetChanged();
    }
}
