package com.baidu.tieba.home;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.data.ad;
import com.baidu.tieba.data.ae;
import com.baidu.tieba.data.ap;
import com.baidu.tieba.data.y;
import com.baidu.tieba.data.z;
/* loaded from: classes.dex */
public class o extends BaseAdapter {
    private com.baidu.tieba.data.o aMI;
    private boolean aMJ;
    private boolean aMK;
    private View.OnClickListener aML;
    private View.OnLongClickListener aMM;
    private BannerView aMN;
    private BaseFragmentActivity mActivity;
    private z aME = null;
    private ap aMF = null;
    private int aMG = 0;
    private int aMH = 0;
    private View.OnClickListener aMO = new p(this);

    public void cu(boolean z) {
        this.aMK = z;
    }

    public o(BaseFragmentActivity baseFragmentActivity) {
        this.mActivity = null;
        this.mActivity = baseFragmentActivity;
        initPadding();
    }

    public void initPadding() {
        this.aMH = com.baidu.adp.lib.util.m.dip2px(this.mActivity, 8.0f);
        this.aMG = com.baidu.adp.lib.util.m.dip2px(this.mActivity, 10.0f);
    }

    public void b(z zVar) {
        this.aME = zVar;
    }

    public void b(ap apVar) {
        this.aMF = apVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int size2;
        int i = 0;
        if (this.aME == null) {
            return 0;
        }
        if (this.aME.zz() != null && (size2 = this.aME.zz().size()) > 0) {
            i = size2 > 500 ? 250 : (size2 + 1) / 2;
        }
        if (this.aMF != null && this.aMF.Aq() != null && (size = this.aMF.Aq().size()) > 0) {
            i = size > 500 ? 250 : i + 1 + ((size + 1) / 2);
        }
        if (this.aMJ) {
            i++;
        }
        return this.aMK ? i + 1 : i;
    }

    public int IN() {
        int size;
        if (this.aME.zz() == null || (size = this.aME.zz().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int IO() {
        int size;
        if (this.aMF == null || this.aMF.Aq() == null || (size = this.aMF.Aq().size()) <= 0) {
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
        if (this.aMJ) {
            i--;
        }
        if (this.aMK) {
            i--;
        }
        int IN = (i - 1) - ((IN() + 1) / 2);
        if (IN >= 0) {
            ae aeVar = new ae();
            if (IN * 2 < this.aMF.Aq().size()) {
                aeVar.alG = this.aMF.Aq().get(IN * 2);
            }
            if ((IN * 2) + 1 < this.aMF.Aq().size()) {
                aeVar.alH = this.aMF.Aq().get((IN * 2) + 1);
            }
            return aeVar;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int IO = (IO() + 1) / 2;
        if (this.aMJ && i == 0) {
            return 2;
        }
        if (this.aMK) {
            if (this.aMJ && i == 1) {
                return 1;
            }
            if (!this.aMJ && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - IO) - 1) {
            return 0;
        }
        if (i == (getCount() - IO) - 1) {
            return IO > 0 ? 4 : 0;
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
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_like_guide, null);
            if (IN() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.aMO);
            F(view);
        } else if (itemViewType == 2) {
            if (this.aMN == null) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_like_item_banner, null);
                this.aMN = (BannerView) view.findViewById(com.baidu.tieba.v.home_like_banner_view);
            }
            this.aMN.R("enter_bar_bck", "");
            if (this.aMI.yR() != null && this.aMI.yR().adA() != null && !this.aMI.yR().adA().isEmpty() && this.aMI.yR().adA().get(0).kJ() != "" && this.aMI.yR().adA().get(0).kJ() != null && this.aMI.yR().adA().get(0).getLink() != null) {
                this.aMN.S(this.aMI.yR().adA().get(0).kJ(), this.aMI.yR().adA().get(0).getLink());
            }
        } else if (itemViewType == 0) {
            if (this.aMJ) {
                i--;
            }
            if (this.aMK) {
                i--;
            }
            int skinType = TbadkApplication.m251getInst().getSkinType();
            if (view == null) {
                view = a((u) null);
            }
            u uVar = 0 == 0 ? (u) view.getTag() : null;
            if (uVar != null && this.aME != null && this.aME.zz() != null) {
                this.mActivity.getLayoutMode().L(skinType == 1);
                this.mActivity.getLayoutMode().h(view);
                a(skinType, uVar);
                uVar.aNh.setPadding(this.aMG, this.aMH, this.aMG, 0);
                if (i >= 0) {
                    if (i * 2 < this.aME.zz().size()) {
                        a(this.aME.zz().get(i * 2), uVar);
                    }
                    if ((i * 2) + 1 < this.aME.zz().size()) {
                        uVar.aNl.aNi.setVisibility(0);
                        a(this.aME.zz().get((i * 2) + 1), uVar.aNl);
                    } else {
                        uVar.aNl.aNi.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_new_recommend_notice, null);
            if (IO() > 0) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            F(view);
        } else if (itemViewType == 3) {
            if (this.aMJ) {
                i--;
            }
            if (this.aMK) {
                i--;
            }
            int IN = (i - 1) - ((IN() + 1) / 2);
            int skinType2 = TbadkApplication.m251getInst().getSkinType();
            view = a((v) null);
            v vVar = 0 == 0 ? (v) view.getTag() : null;
            if (vVar != null && this.aMF != null && this.aMF.Aq() != null) {
                this.mActivity.getLayoutMode().L(skinType2 == 1);
                this.mActivity.getLayoutMode().h(view);
                if (IN >= 0) {
                    if (IN * 2 < this.aMF.Aq().size()) {
                        a(this.aMF.Aq().get(IN * 2), vVar);
                    }
                    if ((IN * 2) + 1 < this.aMF.Aq().size()) {
                        vVar.aNo.aNi.setVisibility(0);
                        a(this.aMF.Aq().get((IN * 2) + 1), vVar.aNo);
                    } else {
                        vVar.aNo.aNi.setVisibility(4);
                    }
                }
            }
        }
        return view;
    }

    private void F(View view) {
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
    }

    private View a(u uVar) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_like_item, null);
        u uVar2 = new u();
        uVar2.aNh = (LinearLayout) inflate;
        uVar2.aNk = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign1);
        uVar2.aNi = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_left);
        uVar2.aNi.setOnClickListener(this.aML);
        uVar2.aNi.setOnLongClickListener(this.aMM);
        uVar2.axz = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum1);
        uVar2.aNj = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade1);
        uVar2.aNl = new u();
        uVar2.aNl.aNk = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign2);
        uVar2.aNl.aNi = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_right);
        uVar2.aNl.aNi.setOnClickListener(this.aML);
        uVar2.aNl.aNi.setOnLongClickListener(this.aMM);
        uVar2.aNl.axz = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum2);
        uVar2.aNl.aNj = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade2);
        inflate.setTag(uVar2);
        return inflate;
    }

    private View a(v vVar) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_recommend_item, null);
        v vVar2 = new v();
        vVar2.aNh = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.home_recommend_container);
        vVar2.aNi = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_left);
        vVar2.aNi.setOnClickListener(this.aML);
        vVar2.axz = (TextView) inflate.findViewById(com.baidu.tieba.v.left_bar_name);
        vVar2.aNn = (TextView) inflate.findViewById(com.baidu.tieba.v.left_focus_num);
        vVar2.aNm = (BarImageView) inflate.findViewById(com.baidu.tieba.v.left_bar_pic);
        vVar2.aNo = new v();
        vVar2.aNo.aNi = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_right);
        vVar2.aNo.aNi.setOnClickListener(this.aML);
        vVar2.aNo.axz = (TextView) inflate.findViewById(com.baidu.tieba.v.right_bar_name);
        vVar2.aNo.aNn = (TextView) inflate.findViewById(com.baidu.tieba.v.right_focus_num);
        vVar2.aNo.aNm = (BarImageView) inflate.findViewById(com.baidu.tieba.v.right_bar_pic);
        inflate.setTag(vVar2);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, u uVar) {
        if (uVar != null && uVar.bF(i)) {
            aw.h(uVar.aNi, com.baidu.tieba.u.home_like_item_bg);
            aw.h(uVar.aNl.aNi, com.baidu.tieba.u.home_like_item_bg);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aML = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.aMM = onLongClickListener;
    }

    private void a(y yVar, u uVar) {
        if (yVar != null && uVar != null) {
            int level = yVar.getLevel();
            uVar.aNi.setTag(yVar);
            uVar.axz.setText(yVar.getName());
            if (yVar.zy() == 0) {
                uVar.aNk.setVisibility(8);
            } else {
                uVar.aNk.setVisibility(0);
            }
            if (level == 0) {
                uVar.aNj.setVisibility(4);
                return;
            }
            uVar.aNj.setVisibility(0);
            aw.h((View) uVar.aNj, com.baidu.tbadk.core.util.d.bn(level));
            uVar.aNj.setText(String.valueOf(yVar.getLevel()));
        }
    }

    private void a(ad adVar, v vVar) {
        if (adVar != null && vVar != null) {
            vVar.aNi.setTag(adVar);
            vVar.axz.setText(adVar.getForumName());
            vVar.aNn.setText(String.valueOf(this.mActivity.getResources().getString(com.baidu.tieba.y.enter_forum_recommend_focus)) + String.valueOf(adVar.zG()));
            if (!TextUtils.isEmpty(adVar.getAvatar())) {
                vVar.aNm.setTag(adVar.getAvatar());
                vVar.aNm.c(adVar.getAvatar(), 10, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.o oVar) {
        this.aMI = oVar;
        if (this.aMN != null) {
            this.aMN.reset();
        }
        if (oVar.yR() != null && oVar.yR().adA() != null && !oVar.yR().adA().isEmpty() && this.aMI.yR().adA().get(0).kJ() != "" && this.aMI.yR().adA().get(0).kJ() != null && this.aMI.yR().adA().get(0).getLink() != null) {
            this.aMJ = true;
        } else {
            this.aMJ = false;
        }
        b(oVar.yS());
        b(oVar.yT());
        notifyDataSetChanged();
    }
}
