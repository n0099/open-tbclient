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
    private com.baidu.tieba.data.o aMu;
    private boolean aMv;
    private boolean aMw;
    private View.OnClickListener aMx;
    private View.OnLongClickListener aMy;
    private BannerView aMz;
    private BaseFragmentActivity mActivity;
    private z aMq = null;
    private ap aMr = null;
    private int aMs = 0;
    private int aMt = 0;
    private View.OnClickListener aMA = new p(this);

    public void cu(boolean z) {
        this.aMw = z;
    }

    public o(BaseFragmentActivity baseFragmentActivity) {
        this.mActivity = null;
        this.mActivity = baseFragmentActivity;
        initPadding();
    }

    public void initPadding() {
        this.aMt = com.baidu.adp.lib.util.m.dip2px(this.mActivity, 8.0f);
        this.aMs = com.baidu.adp.lib.util.m.dip2px(this.mActivity, 10.0f);
    }

    public void b(z zVar) {
        this.aMq = zVar;
    }

    public void b(ap apVar) {
        this.aMr = apVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        int size2;
        int i = 0;
        if (this.aMq == null) {
            return 0;
        }
        if (this.aMq.zx() != null && (size2 = this.aMq.zx().size()) > 0) {
            i = size2 > 500 ? 250 : (size2 + 1) / 2;
        }
        if (this.aMr != null && this.aMr.Ao() != null && (size = this.aMr.Ao().size()) > 0) {
            i = size > 500 ? 250 : i + 1 + ((size + 1) / 2);
        }
        if (this.aMv) {
            i++;
        }
        return this.aMw ? i + 1 : i;
    }

    public int IJ() {
        int size;
        if (this.aMq.zx() == null || (size = this.aMq.zx().size()) <= 0) {
            return 0;
        }
        if (size > 500) {
            return 500;
        }
        return size;
    }

    public int IK() {
        int size;
        if (this.aMr == null || this.aMr.Ao() == null || (size = this.aMr.Ao().size()) <= 0) {
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
        if (this.aMv) {
            i--;
        }
        if (this.aMw) {
            i--;
        }
        int IJ = (i - 1) - ((IJ() + 1) / 2);
        if (IJ >= 0) {
            ae aeVar = new ae();
            if (IJ * 2 < this.aMr.Ao().size()) {
                aeVar.alx = this.aMr.Ao().get(IJ * 2);
            }
            if ((IJ * 2) + 1 < this.aMr.Ao().size()) {
                aeVar.aly = this.aMr.Ao().get((IJ * 2) + 1);
            }
            return aeVar;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int IK = (IK() + 1) / 2;
        if (this.aMv && i == 0) {
            return 2;
        }
        if (this.aMw) {
            if (this.aMv && i == 1) {
                return 1;
            }
            if (!this.aMv && i == 0) {
                return 1;
            }
        }
        if (i < (getCount() - IK) - 1) {
            return 0;
        }
        if (i == (getCount() - IK) - 1) {
            return IK > 0 ? 4 : 0;
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
            if (IJ() <= 4) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view.setOnClickListener(this.aMA);
            F(view);
        } else if (itemViewType == 2) {
            if (this.aMz == null) {
                view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_like_item_banner, null);
                this.aMz = (BannerView) view.findViewById(com.baidu.tieba.v.home_like_banner_view);
            }
            this.aMz.R("enter_bar_bck", "");
            if (this.aMu.yP() != null && this.aMu.yP().adx() != null && !this.aMu.yP().adx().isEmpty() && this.aMu.yP().adx().get(0).kJ() != "" && this.aMu.yP().adx().get(0).kJ() != null && this.aMu.yP().adx().get(0).getLink() != null) {
                this.aMz.S(this.aMu.yP().adx().get(0).kJ(), this.aMu.yP().adx().get(0).getLink());
            }
        } else if (itemViewType == 0) {
            if (this.aMv) {
                i--;
            }
            if (this.aMw) {
                i--;
            }
            int skinType = TbadkApplication.m251getInst().getSkinType();
            if (view == null) {
                view = a((u) null);
            }
            u uVar = 0 == 0 ? (u) view.getTag() : null;
            if (uVar != null && this.aMq != null && this.aMq.zx() != null) {
                this.mActivity.getLayoutMode().L(skinType == 1);
                this.mActivity.getLayoutMode().h(view);
                a(skinType, uVar);
                uVar.aMT.setPadding(this.aMs, this.aMt, this.aMs, 0);
                if (i >= 0) {
                    if (i * 2 < this.aMq.zx().size()) {
                        a(this.aMq.zx().get(i * 2), uVar);
                    }
                    if ((i * 2) + 1 < this.aMq.zx().size()) {
                        uVar.aMX.aMU.setVisibility(0);
                        a(this.aMq.zx().get((i * 2) + 1), uVar.aMX);
                    } else {
                        uVar.aMX.aMU.setVisibility(4);
                    }
                }
            }
        } else if (itemViewType == 4) {
            view = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_new_recommend_notice, null);
            if (IK() > 0) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            F(view);
        } else if (itemViewType == 3) {
            if (this.aMv) {
                i--;
            }
            if (this.aMw) {
                i--;
            }
            int IJ = (i - 1) - ((IJ() + 1) / 2);
            int skinType2 = TbadkApplication.m251getInst().getSkinType();
            view = a((v) null);
            v vVar = 0 == 0 ? (v) view.getTag() : null;
            if (vVar != null && this.aMr != null && this.aMr.Ao() != null) {
                this.mActivity.getLayoutMode().L(skinType2 == 1);
                this.mActivity.getLayoutMode().h(view);
                if (IJ >= 0) {
                    if (IJ * 2 < this.aMr.Ao().size()) {
                        a(this.aMr.Ao().get(IJ * 2), vVar);
                    }
                    if ((IJ * 2) + 1 < this.aMr.Ao().size()) {
                        vVar.aNa.aMU.setVisibility(0);
                        a(this.aMr.Ao().get((IJ * 2) + 1), vVar.aNa);
                    } else {
                        vVar.aNa.aMU.setVisibility(4);
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
        uVar2.aMT = (LinearLayout) inflate;
        uVar2.aMW = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign1);
        uVar2.aMU = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_left);
        uVar2.aMU.setOnClickListener(this.aMx);
        uVar2.aMU.setOnLongClickListener(this.aMy);
        uVar2.axq = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum1);
        uVar2.aMV = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade1);
        uVar2.aMX = new u();
        uVar2.aMX.aMW = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_icon_sign2);
        uVar2.aMX.aMU = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.item_right);
        uVar2.aMX.aMU.setOnClickListener(this.aMx);
        uVar2.aMX.aMU.setOnLongClickListener(this.aMy);
        uVar2.aMX.axq = (TextView) inflate.findViewById(com.baidu.tieba.v.home_lv_like_forum2);
        uVar2.aMX.aMV = (TextView) inflate.findViewById(com.baidu.tieba.v.forum_lv_like_grade2);
        inflate.setTag(uVar2);
        return inflate;
    }

    private View a(v vVar) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.home_recommend_item, null);
        v vVar2 = new v();
        vVar2.aMT = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.home_recommend_container);
        vVar2.aMU = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_left);
        vVar2.aMU.setOnClickListener(this.aMx);
        vVar2.axq = (TextView) inflate.findViewById(com.baidu.tieba.v.left_bar_name);
        vVar2.aMZ = (TextView) inflate.findViewById(com.baidu.tieba.v.left_focus_num);
        vVar2.aMY = (BarImageView) inflate.findViewById(com.baidu.tieba.v.left_bar_pic);
        vVar2.aNa = new v();
        vVar2.aNa.aMU = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.recommend_item_right);
        vVar2.aNa.aMU.setOnClickListener(this.aMx);
        vVar2.aNa.axq = (TextView) inflate.findViewById(com.baidu.tieba.v.right_bar_name);
        vVar2.aNa.aMZ = (TextView) inflate.findViewById(com.baidu.tieba.v.right_focus_num);
        vVar2.aNa.aMY = (BarImageView) inflate.findViewById(com.baidu.tieba.v.right_bar_pic);
        inflate.setTag(vVar2);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        notifyDataSetChanged();
    }

    private void a(int i, u uVar) {
        if (uVar != null && uVar.bF(i)) {
            aw.h(uVar.aMU, com.baidu.tieba.u.home_like_item_bg);
            aw.h(uVar.aMX.aMU, com.baidu.tieba.u.home_like_item_bg);
        }
    }

    public void q(View.OnClickListener onClickListener) {
        this.aMx = onClickListener;
    }

    public void a(View.OnLongClickListener onLongClickListener) {
        this.aMy = onLongClickListener;
    }

    private void a(y yVar, u uVar) {
        if (yVar != null && uVar != null) {
            int level = yVar.getLevel();
            uVar.aMU.setTag(yVar);
            uVar.axq.setText(yVar.getName());
            if (yVar.zw() == 0) {
                uVar.aMW.setVisibility(8);
            } else {
                uVar.aMW.setVisibility(0);
            }
            if (level == 0) {
                uVar.aMV.setVisibility(4);
                return;
            }
            uVar.aMV.setVisibility(0);
            aw.h((View) uVar.aMV, com.baidu.tbadk.core.util.d.bn(level));
            uVar.aMV.setText(String.valueOf(yVar.getLevel()));
        }
    }

    private void a(ad adVar, v vVar) {
        if (adVar != null && vVar != null) {
            vVar.aMU.setTag(adVar);
            vVar.axq.setText(adVar.getForumName());
            vVar.aMZ.setText(String.valueOf(this.mActivity.getResources().getString(com.baidu.tieba.y.enter_forum_recommend_focus)) + String.valueOf(adVar.zE()));
            if (!TextUtils.isEmpty(adVar.getAvatar())) {
                vVar.aMY.setTag(adVar.getAvatar());
                vVar.aMY.c(adVar.getAvatar(), 10, false);
            }
        }
    }

    public void a(com.baidu.tieba.data.o oVar) {
        this.aMu = oVar;
        if (this.aMz != null) {
            this.aMz.reset();
        }
        if (oVar.yP() != null && oVar.yP().adx() != null && !oVar.yP().adx().isEmpty() && this.aMu.yP().adx().get(0).kJ() != "" && this.aMu.yP().adx().get(0).kJ() != null && this.aMu.yP().adx().get(0).getLink() != null) {
            this.aMv = true;
        } else {
            this.aMv = false;
        }
        b(oVar.yQ());
        b(oVar.yR());
        notifyDataSetChanged();
    }
}
