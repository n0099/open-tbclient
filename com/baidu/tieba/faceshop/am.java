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
    private final LinearLayout Hk;
    private final TextView JM;
    private WindowManager.LayoutParams Rq;
    private GifView Rr;
    private int Rv;
    private int Rw;
    private TextView atA;
    private final TextView atB;
    private final TextView atC;
    private final TextView atD;
    private final TextView atE;
    private final FrameLayout atF;
    private final ImageView atG;
    private final ImageView atH;
    private final int atI;
    private final int atJ;
    private final int atK;
    private final GridView atL;
    private ar atM;
    private final v atN;
    private boolean atO;
    private boolean atP;
    private final ScrollView atQ;
    private int atR;
    private final TbImageView atT;
    private final NavigationBar atx;
    private final NoNetworkView aty;
    private final TbImageView atz;
    private WindowManager go;
    private final BaseActivity mActivity;
    private final Handler mHandler;
    private int mHeight;
    private final LinearLayout mParent;
    private final int mSkinType;
    private int mWidth;
    private int atS = -1;
    private final Runnable atU = new an(this);

    public am(BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        baseActivity.setContentView(ca.face_package_detail_activity);
        this.mParent = (LinearLayout) baseActivity.findViewById(bz.face_package);
        this.atx = (NavigationBar) baseActivity.findViewById(bz.view_navigation_bar);
        this.atx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.atA = this.atx.setTitleText("");
        this.aty = (NoNetworkView) baseActivity.findViewById(bz.view_no_network);
        this.Hk = (LinearLayout) this.mParent.findViewById(bz.face_package_container);
        this.atz = (TbImageView) this.mParent.findViewById(bz.face_package_cover);
        this.JM = (TextView) this.mParent.findViewById(bz.face_package_title);
        this.atB = (TextView) this.mParent.findViewById(bz.face_package_price);
        this.atC = (TextView) this.mParent.findViewById(bz.face_package_status);
        this.atD = (TextView) this.mParent.findViewById(bz.face_package_btn);
        this.atE = (TextView) this.mParent.findViewById(bz.face_package_info);
        this.atL = (GridView) this.mParent.findViewById(bz.face_package_faces);
        this.atT = (TbImageView) this.mParent.findViewById(bz.face_package_title_tag);
        this.atT.setDefaultResource(0);
        this.atT.setDefaultBgResource(0);
        this.atL.setSelection(-1);
        this.atL.setOnItemLongClickListener(baseActivity);
        this.atL.setOnItemClickListener(new ao(this));
        this.atF = (FrameLayout) this.mParent.findViewById(bz.face_package_downloading);
        this.atG = (ImageView) this.mParent.findViewById(bz.face_package_downloading_up);
        this.atH = (ImageView) this.mParent.findViewById(bz.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        this.mWidth = baseActivity.getResources().getDimensionPixelSize(bx.faceshop_cover_width);
        this.mHeight = baseActivity.getResources().getDimensionPixelSize(bx.faceshop_cover_height);
        this.mHandler = new Handler();
        this.atD.setOnClickListener(baseActivity);
        this.atH.setOnClickListener(baseActivity);
        Bitmap bl = com.baidu.tbadk.core.util.d.bl(by.bg_content_buy_bar_down);
        Bitmap bl2 = com.baidu.tbadk.core.util.d.bl(by.bg_content_buy_bar_up);
        this.atJ = bl.getWidth();
        this.atI = bl2.getWidth();
        this.atK = this.mActivity.getResources().getDimensionPixelSize(bx.faceshop_page_padding);
        this.atN = new v(baseActivity, cc.common_alert_dialog);
        this.atQ = (ScrollView) this.mParent.findViewById(bz.container_scrollview);
        T(baseActivity);
    }

    private void T(Context context) {
        this.Rr = new GifView(context);
        com.baidu.tbadk.core.util.aw.h(this.Rr, by.bg_expression_bubble);
        this.Rr.setVisibility(8);
        this.go = (WindowManager) context.getSystemService("window");
        this.Rq = new WindowManager.LayoutParams();
        this.Rv = context.getResources().getDimensionPixelSize(bx.face_tab_content_float_width);
        this.Rw = context.getResources().getDimensionPixelSize(bx.face_tab_content_float_height);
        this.Rq.width = this.Rv;
        this.Rq.height = this.Rw;
        this.Rq.gravity = 51;
        this.Rq.format = -3;
        this.Rq.type = 1000;
        this.Rq.flags |= 56;
        this.atR = com.baidu.adp.lib.util.m.f((Activity) context);
        if (MenuKeyUtils.hasSmartBar()) {
            this.Rq.type = 1000;
            this.Rq.flags = 25165832;
        }
    }

    public void g(ak akVar) {
        if (akVar != null) {
            h(akVar);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.atL.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.m.n(this.mActivity) - (this.atK * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
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
            if (this.atM == null) {
                this.atM = new ar(this.mActivity, facePackageData.face_list);
                this.atL.setAdapter((ListAdapter) this.atM);
                return;
            }
            this.atM.setData(facePackageData.face_list);
            this.atM.notifyDataSetChanged();
        }
    }

    public void h(ak akVar) {
        FacePackageData facePackageData;
        if (akVar != null && akVar.CY() != null && (facePackageData = akVar.CY().faces_list) != null) {
            if (akVar.Da()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.Hk.setVisibility(0);
            this.atz.setTag(facePackageData.cover_url);
            this.JM.setText(facePackageData.pname);
            this.atT.setTag(facePackageData.tag_url);
            this.atB.setText(String.valueOf(this.mActivity.getResources().getString(cb.price_tip)) + facePackageData.price);
            this.atE.setText(facePackageData.pdesc);
            this.atA.setText(facePackageData.pname);
            b(facePackageData);
            eT(akVar.getPid());
            c(facePackageData);
            Dd();
        }
    }

    private void Dd() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.atU);
            this.mHandler.postDelayed(this.atU, 90L);
        }
    }

    public void De() {
        if (this.atz != null && this.atz.getTag() != null) {
            this.atz.a(this.atz.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.atT != null && this.atT.getTag() != null) {
            this.atT.a(this.atT.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.aty.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.aty.b(uVar);
    }

    public void i(ak akVar) {
        if (akVar != null && akVar.CY() != null && akVar.CY().faces_list != null) {
            FacePackageData facePackageData = akVar.CY().faces_list;
            if (facePackageData.buy_status == 1) {
                this.atC.setText(this.mActivity.getResources().getString(cb.has_buy));
                this.atC.setVisibility(0);
            } else {
                this.atC.setVisibility(8);
            }
            switch (akVar.Db()) {
                case 1:
                    Df();
                    return;
                case 2:
                case 3:
                    Dh();
                    return;
                case 4:
                    Dg();
                    return;
                case 5:
                    b(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    Di();
                    return;
                default:
                    return;
            }
        }
    }

    public void Df() {
        this.atD.setVisibility(0);
        this.atF.setVisibility(8);
        this.atD.setText(this.mActivity.getResources().getString(cb.downloaded));
        com.baidu.tbadk.core.util.aw.b(this.atD, bw.faceshop_downloaded_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atD, by.btn_content_buy_d);
    }

    public void b(long j, long j2) {
        this.atD.setVisibility(8);
        this.atF.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.atJ);
        int i2 = i < this.atI ? this.atI : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.atG.getLayoutParams();
        layoutParams.width = i2;
        this.atG.setLayoutParams(layoutParams);
    }

    public void Dg() {
        this.atD.setVisibility(0);
        this.atF.setVisibility(8);
        this.atD.setText(this.mActivity.getResources().getString(cb.buy_package));
        com.baidu.tbadk.core.util.aw.h((View) this.atD, by.faceshop_package_btn_selector);
    }

    public void Dh() {
        this.atD.setVisibility(0);
        this.atF.setVisibility(8);
        this.atD.setText(this.mActivity.getResources().getString(cb.can_download));
        com.baidu.tbadk.core.util.aw.b(this.atD, bw.faceshop_package_btn_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atD, by.faceshop_package_btn_selector);
    }

    private void Di() {
        this.atD.setVisibility(0);
        this.atF.setVisibility(8);
        this.atD.setText(this.mActivity.getResources().getString(cb.off_the_shelf));
        com.baidu.tbadk.core.util.aw.b(this.atD, bw.faceshop_downloaded_text, 1);
        com.baidu.tbadk.core.util.aw.h((View) this.atD, by.btn_content_buy_d);
    }

    public void Dj() {
        if (this.atN != null) {
            this.atN.CO();
            com.baidu.adp.lib.g.j.a(this.atN, this.mActivity);
        }
    }

    public void Dk() {
        if (this.atN != null) {
            this.atN.CP();
        }
    }

    public void Dl() {
        if (this.atN != null) {
            com.baidu.adp.lib.g.j.b(this.atN, this.mActivity);
        }
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.mParent);
        if (this.atx != null) {
            this.atx.onChangeSkinType(i);
        }
        if (this.aty != null) {
            this.aty.onChangeSkinType(i);
        }
    }

    public void Dm() {
        if (this.aty != null && this.aty.getVisibility() == 0 && com.baidu.adp.lib.util.j.fh()) {
            this.aty.Z(false);
        }
    }

    public TextView Dn() {
        return this.atD;
    }

    public ImageView Do() {
        return this.atH;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.atS && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.atS != -1) {
                m(this.atS, false);
            }
            this.atS = i;
            this.atL.setSelection(i);
            m(i, true);
            this.atP = true;
            this.Rr.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.Rr.setTag(str);
            if (com.baidu.tbadk.util.e.va()) {
                com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
                aVar.Ti = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar.Tf = str;
                aVar.Tk = this.mHeight;
                aVar.Tj = this.mWidth;
                aVar.Th = facePackageData.face_dynamic_list.get(i);
                this.Rr.a(aVar);
            } else {
                com.baidu.tbadk.gif.a aVar2 = new com.baidu.tbadk.gif.a();
                aVar2.Ti = new StringBuilder(String.valueOf(facePackageData.pid)).toString();
                aVar2.Tk = this.mHeight;
                aVar2.Tj = this.mWidth;
                aVar2.Tf = str;
                aVar2.Tg = facePackageData.face_list.get(i);
                this.Rr.a(aVar2);
            }
            this.Rq.x = rect.left - ((this.Rv - rect.width()) / 2);
            this.Rq.y = rect.top - this.Rq.height;
            if (this.Rq.y < this.atR) {
                this.atQ.scrollBy(0, this.Rq.y - this.atR);
                this.Rq.y = this.atR;
            }
            this.Rq.y += this.atL.getChildAt(i - this.atL.getFirstVisiblePosition()).getPaddingTop();
            if (!this.atO) {
                this.go.addView(this.Rr, this.Rq);
                this.atO = true;
                return;
            }
            this.go.updateViewLayout(this.Rr, this.Rq);
        }
    }

    public boolean Dp() {
        return this.atP;
    }

    public void Dq() {
        this.atP = false;
        this.Rr.setVisibility(8);
        this.atL.setSelection(-1);
        m(this.atS, false);
        this.atS = -1;
    }

    private void m(int i, boolean z) {
        ((ViewGroup) this.atL.getChildAt(i - this.atL.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void Dr() {
        this.atP = false;
        if (this.atO) {
            this.atO = false;
            this.go.removeView(this.Rr);
        }
    }

    public GridView Ds() {
        return this.atL;
    }
}
