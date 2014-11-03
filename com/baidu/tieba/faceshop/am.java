package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.download.QueryDownloadMessage;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class am {
    private final LinearLayout Hl;
    private final TextView JN;
    private int RA;
    private WindowManager.LayoutParams Ru;
    private GifView Rv;
    private int Rz;
    private final NavigationBar atG;
    private final NoNetworkView atH;
    private final TbImageView atI;
    private TextView atJ;
    private final TextView atK;
    private final TextView atL;
    private final TextView atM;
    private final TextView atN;
    private final FrameLayout atO;
    private final ImageView atP;
    private final ImageView atQ;
    private final int atR;
    private final int atS;
    private final int atT;
    private final GridView atU;
    private ar atV;
    private final v atW;
    private boolean atX;
    private boolean atY;
    private final ScrollView atZ;
    private int aua;
    private final TbImageView auc;
    private WindowManager go;
    private final BaseActivity mActivity;
    private final Handler mHandler;
    private int mHeight;
    private final LinearLayout mParent;
    private final int mSkinType;
    private int mWidth;
    private int aub = -1;
    private final Runnable aud = new an(this);

    public am(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_package_detail_activity);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.face_package);
        this.atG = (NavigationBar) baseActivity.findViewById(bz.view_navigation_bar);
        this.atG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.atJ = this.atG.setTitleText("");
        this.atH = (NoNetworkView) baseActivity.findViewById(bz.view_no_network);
        this.Hl = (LinearLayout) this.mParent.findViewById(bz.face_package_container);
        this.atI = (TbImageView) this.mParent.findViewById(bz.face_package_cover);
        this.JN = (TextView) this.mParent.findViewById(bz.face_package_title);
        this.atK = (TextView) this.mParent.findViewById(bz.face_package_price);
        this.atL = (TextView) this.mParent.findViewById(bz.face_package_status);
        this.atM = (TextView) this.mParent.findViewById(bz.face_package_btn);
        this.atN = (TextView) this.mParent.findViewById(bz.face_package_info);
        this.atU = (GridView) this.mParent.findViewById(bz.face_package_faces);
        this.auc = (TbImageView) this.mParent.findViewById(bz.face_package_title_tag);
        this.auc.setDefaultResource(0);
        this.auc.setDefaultBgResource(0);
        this.atU.setSelection(-1);
        this.atU.setOnItemLongClickListener(baseActivity);
        this.atU.setOnItemClickListener(new ao(this));
        this.atO = (FrameLayout) this.mParent.findViewById(bz.face_package_downloading);
        this.atP = (ImageView) this.mParent.findViewById(bz.face_package_downloading_up);
        this.atQ = (ImageView) this.mParent.findViewById(bz.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        this.mWidth = baseActivity.getResources().getDimensionPixelSize(bx.faceshop_cover_width);
        this.mHeight = baseActivity.getResources().getDimensionPixelSize(bx.faceshop_cover_height);
        this.mHandler = new Handler();
        this.atM.setOnClickListener(baseActivity);
        this.atQ.setOnClickListener(baseActivity);
        Bitmap bl = com.baidu.tbadk.core.util.d.bl(by.bg_content_buy_bar_down);
        Bitmap bl2 = com.baidu.tbadk.core.util.d.bl(by.bg_content_buy_bar_up);
        this.atS = bl.getWidth();
        this.atR = bl2.getWidth();
        this.atT = this.mActivity.getResources().getDimensionPixelSize(bx.faceshop_page_padding);
        this.atW = new v(baseActivity, cc.common_alert_dialog);
        this.atZ = (ScrollView) this.mParent.findViewById(bz.container_scrollview);
        T(baseActivity);
    }

    private void T(Context context) {
        this.Rv = new GifView(context);
        com.baidu.tbadk.core.util.aw.h(this.Rv, by.bg_expression_bubble);
        this.Rv.setVisibility(8);
        this.go = (WindowManager) context.getSystemService("window");
        this.Ru = new WindowManager.LayoutParams();
        this.Rz = context.getResources().getDimensionPixelSize(bx.face_tab_content_float_width);
        this.RA = context.getResources().getDimensionPixelSize(bx.face_tab_content_float_height);
        this.Ru.width = this.Rz;
        this.Ru.height = this.RA;
        this.Ru.gravity = 51;
        this.Ru.format = -3;
        this.Ru.type = 1000;
        this.Ru.flags |= 56;
        this.aua = com.baidu.adp.lib.util.m.f((Activity) context);
        if (MenuKeyUtils.hasSmartBar()) {
            this.Ru.type = 1000;
            this.Ru.flags = 25165832;
        }
    }

    public void g(ak akVar) {
        if (akVar != null) {
            h(akVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.atU.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.m.n(this.mActivity) - (this.atT * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void eT(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.atV == null) {
                this.atV = new ar(this.mActivity, facePackageData.face_list);
                this.atU.setAdapter((ListAdapter) this.atV);
                return;
            }
            this.atV.setData(facePackageData.face_list);
            this.atV.notifyDataSetChanged();
        }
    }

    public void h(ak akVar) {
        FacePackageData facePackageData;
        if (akVar != null && akVar.Da() != null && (facePackageData = akVar.Da().faces_list) != null) {
            if (akVar.Dc()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.Hl.setVisibility(0);
            this.atI.setTag(facePackageData.cover_url);
            this.JN.setText(facePackageData.pname);
            this.auc.setTag(facePackageData.tag_url);
            this.atK.setText(String.valueOf(this.mActivity.getResources().getString(cb.price_tip)) + facePackageData.price);
            this.atN.setText(facePackageData.pdesc);
            this.atJ.setText(facePackageData.pname);
            b(facePackageData);
            eT(akVar.getPid());
            c(facePackageData);
            Df();
        }
    }

    private void Df() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.aud);
            this.mHandler.postDelayed(this.aud, 90L);
        }
    }

    public void Dg() {
        if (this.atI != null && this.atI.getTag() != null) {
            this.atI.a(this.atI.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.auc != null && this.auc.getTag() != null) {
            this.auc.a(this.auc.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.atH.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.atH.b(uVar);
    }

    public void i(ak akVar) {
        if (akVar != null && akVar.Da() != null && akVar.Da().faces_list != null) {
            FacePackageData facePackageData = akVar.Da().faces_list;
            if (facePackageData.buy_status == 1) {
                this.atL.setText(this.mActivity.getResources().getString(cb.has_buy));
                this.atL.setVisibility(0);
            } else {
                this.atL.setVisibility(8);
            }
            switch (akVar.Dd()) {
                case 1:
                    Dh();
                    return;
                case 2:
                case 3:
                    Dj();
                    return;
                case 4:
                    Di();
                    return;
                case 5:
                    b(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    Dk();
                    return;
                default:
                    return;
            }
        }
    }

    public void Dh() {
        this.atM.setVisibility(0);
        this.atO.setVisibility(8);
        this.atM.setText(this.mActivity.getResources().getString(cb.downloaded));
        com.baidu.tbadk.core.util.aw.b(this.atM, bw.faceshop_downloaded_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atM, by.btn_content_buy_d);
    }

    public void b(long j, long j2) {
        this.atM.setVisibility(8);
        this.atO.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.atS);
        int i2 = i < this.atR ? this.atR : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.atP.getLayoutParams();
        layoutParams.width = i2;
        this.atP.setLayoutParams(layoutParams);
    }

    public void Di() {
        this.atM.setVisibility(0);
        this.atO.setVisibility(8);
        this.atM.setText(this.mActivity.getResources().getString(cb.buy_package));
        com.baidu.tbadk.core.util.aw.h((View) this.atM, by.faceshop_package_btn_selector);
    }

    public void Dj() {
        this.atM.setVisibility(0);
        this.atO.setVisibility(8);
        this.atM.setText(this.mActivity.getResources().getString(cb.can_download));
        com.baidu.tbadk.core.util.aw.b(this.atM, bw.faceshop_package_btn_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atM, by.faceshop_package_btn_selector);
    }

    private void Dk() {
        this.atM.setVisibility(0);
        this.atO.setVisibility(8);
        this.atM.setText(this.mActivity.getResources().getString(cb.off_the_shelf));
        com.baidu.tbadk.core.util.aw.b(this.atM, bw.faceshop_downloaded_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atM, by.btn_content_buy_d);
    }

    public void Dl() {
        if (this.atW != null) {
            this.atW.CQ();
            com.baidu.adp.lib.g.j.a(this.atW, this.mActivity);
        }
    }

    public void Dm() {
        if (this.atW != null) {
            this.atW.CR();
        }
    }

    public void Dn() {
        if (this.atW != null) {
            com.baidu.adp.lib.g.j.b(this.atW, this.mActivity);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        if (this.atG != null) {
            this.atG.onChangeSkinType(i);
        }
        if (this.atH != null) {
            this.atH.onChangeSkinType(i);
        }
    }

    public void Do() {
        if (this.atH != null && this.atH.getVisibility() == 0 && com.baidu.adp.lib.util.j.fh()) {
            this.atH.Z(false);
        }
    }

    public TextView Dp() {
        return this.atM;
    }

    public ImageView Dq() {
        return this.atQ;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.aub && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.aub != -1) {
                m(this.aub, false);
            }
            this.aub = i;
            this.atU.setSelection(i);
            m(i, true);
            this.atY = true;
            this.Rv.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.Rv.setTag(str);
            if (com.baidu.tbadk.util.e.vc()) {
                com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
                aVar.Tm = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar.Tj = str;
                aVar.To = this.mHeight;
                aVar.Tn = this.mWidth;
                aVar.Tl = facePackageData.face_dynamic_list.get(i);
                this.Rv.a(aVar);
            } else {
                com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
                aVar2.Tm = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar2.To = this.mHeight;
                aVar2.Tn = this.mWidth;
                aVar2.Tj = str;
                aVar2.Tk = facePackageData.face_list.get(i);
                this.Rv.a(aVar2);
            }
            this.Ru.x = rect.left - ((this.Rz - rect.width()) / 2);
            this.Ru.y = rect.top - this.Ru.height;
            if (this.Ru.y < this.aua) {
                this.atZ.scrollBy(0, this.Ru.y - this.aua);
                this.Ru.y = this.aua;
            }
            this.Ru.y += this.atU.getChildAt(i - this.atU.getFirstVisiblePosition()).getPaddingTop();
            if (!this.atX) {
                this.go.addView(this.Rv, this.Ru);
                this.atX = true;
                return;
            }
            this.go.updateViewLayout(this.Rv, this.Ru);
        }
    }

    public boolean Dr() {
        return this.atY;
    }

    public void Ds() {
        this.atY = false;
        this.Rv.setVisibility(8);
        this.atU.setSelection(-1);
        m(this.aub, false);
        this.aub = -1;
    }

    private void m(int i, boolean z) {
        ((ViewGroup) this.atU.getChildAt(i - this.atU.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void Dt() {
        this.atY = false;
        if (this.atX) {
            this.atX = false;
            this.go.removeView(this.Rv);
        }
    }

    public GridView Du() {
        return this.atU;
    }
}
