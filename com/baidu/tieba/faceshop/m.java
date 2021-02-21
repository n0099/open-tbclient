package com.baidu.tieba.faceshop;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.compatible.menukey.MenuKeyUtils;
import java.util.LinkedList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class m {
    private TextView bMg;
    private int cBN;
    private final TextView fBb;
    private final TextView fjt;
    private final TbImageView gFp;
    private final NoNetworkView gyk;
    private WindowManager.LayoutParams iFO;
    private GifView iFP;
    private int iFR;
    private int iFS;
    private final GridView iVA;
    private n iVB;
    private final j iVC;
    private boolean iVD;
    private boolean iVE;
    private final ScrollView iVF;
    private final TbImageView iVH;
    private final TbPageContext<l> iVp;
    private final NavigationBar iVq;
    private final TextView iVr;
    private final TextView iVs;
    private final FrameLayout iVt;
    private final ImageView iVu;
    private final ImageView iVv;
    private TextView iVw;
    private final int iVx;
    private final int iVy;
    private final int iVz;
    private final LinearLayout mContainer;
    private final Handler mHandler;
    private int mHeight;
    private final View mParent;
    private final int mSkinType;
    private final TextView mTitle;
    private int mWidth;
    private WindowManager mWindowManager;
    private int iVG = -1;
    private final Runnable iVI = new Runnable() { // from class: com.baidu.tieba.faceshop.m.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.Xq();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    };

    public m(TbPageContext<l> tbPageContext) {
        this.iVp = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        this.iVq = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iVq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bMg = this.iVq.setTitleText("");
        this.gyk = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.mContainer = (LinearLayout) this.mParent.findViewById(R.id.face_package_container);
        this.iVw = (TextView) this.mParent.findViewById(R.id.top_view);
        ((LinearLayout.LayoutParams) this.iVw.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iVp.getPageActivity(), R.dimen.ds98);
        this.gFp = (TbImageView) this.mParent.findViewById(R.id.face_package_cover);
        this.mTitle = (TextView) this.mParent.findViewById(R.id.face_package_title);
        this.fjt = (TextView) this.mParent.findViewById(R.id.face_package_price);
        this.iVr = (TextView) this.mParent.findViewById(R.id.face_package_status);
        this.fBb = (TextView) this.mParent.findViewById(R.id.face_package_btn);
        this.iVs = (TextView) this.mParent.findViewById(R.id.face_package_info);
        this.iVA = (GridView) this.mParent.findViewById(R.id.face_package_faces);
        this.iVH = (TbImageView) this.mParent.findViewById(R.id.face_package_title_tag);
        this.iVH.setDefaultResource(0);
        this.iVH.setDefaultBgResource(0);
        this.iVA.setSelection(-1);
        try {
            this.iVA.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iVA.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.m.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m.this.iVA.setSelection(-1);
            }
        });
        this.iVt = (FrameLayout) this.mParent.findViewById(R.id.face_package_downloading);
        this.iVu = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_up);
        this.iVv = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        this.mWidth = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHeight = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHandler = new Handler();
        this.fBb.setOnClickListener(tbPageContext.getOrignalPage());
        this.iVv.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.iVy = cashBitmap.getWidth();
        this.iVx = cashBitmap2.getWidth();
        this.iVz = this.iVp.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.iVC = new j(this.iVp, R.style.common_alert_dialog);
        this.iVF = (ScrollView) this.mParent.findViewById(R.id.container_scrollview);
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.iFP = new GifView(tbPageContext.getPageActivity());
        ap.setBackgroundResource(this.iFP, R.drawable.bg_expression_bubble);
        this.iFP.setVisibility(8);
        this.iFP.setSupportNoImage(false);
        this.mWindowManager = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.iFO = new WindowManager.LayoutParams();
        this.iFR = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        this.iFS = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iFO.width = this.iFR;
        this.iFO.height = this.iFS;
        this.iFO.gravity = 51;
        this.iFO.format = -3;
        this.iFO.type = 1000;
        this.iFO.flags |= 56;
        this.cBN = com.baidu.adp.lib.util.l.getStatusBarHeight(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            this.iFO.type = 1000;
            this.iFO.flags = 25165832;
        }
    }

    public void g(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null) {
            h(facePackageDetailModel);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.iVA.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.iVp.getPageActivity()) - (this.iVz * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void JN(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.iVB == null) {
                this.iVB = new n(this.iVp.getPageActivity(), facePackageData.face_list);
                this.iVA.setAdapter((ListAdapter) this.iVB);
                return;
            }
            this.iVB.setData(facePackageData.face_list);
            this.iVB.notifyDataSetChanged();
        }
    }

    public void h(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel != null && facePackageDetailModel.cyW() != null && (facePackageData = facePackageDetailModel.cyW().faces_list) != null) {
            if (facePackageDetailModel.cyY()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.mContainer.setVisibility(0);
            this.gFp.setTag(facePackageData.cover_url);
            this.mTitle.setText(facePackageData.pname);
            this.iVH.setTag(facePackageData.tag_url);
            this.fjt.setText(this.iVp.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.iVs.setText(facePackageData.pdesc);
            this.bMg.setText(facePackageData.pname);
            b(facePackageData);
            JN(facePackageDetailModel.getPid());
            c(facePackageData);
            czb();
        }
    }

    private void czb() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iVI);
            this.mHandler.postDelayed(this.iVI, 90L);
        }
    }

    public void Xq() {
        if (this.gFp != null && this.gFp.getTag() != null) {
            this.gFp.a(this.gFp.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.iVH != null && this.iVH.getTag() != null) {
            this.iVH.a(this.iVH.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iVw, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c(NoNetworkView.a aVar) {
        this.gyk.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gyk.b(aVar);
    }

    public void i(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null && facePackageDetailModel.cyW() != null && facePackageDetailModel.cyW().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.cyW().faces_list;
            if (facePackageData.buy_status == 1) {
                this.iVr.setText(this.iVp.getResources().getString(R.string.has_buy));
                this.iVr.setVisibility(0);
            } else {
                this.iVr.setVisibility(8);
            }
            switch (facePackageDetailModel.cyZ()) {
                case 1:
                    czc();
                    return;
                case 2:
                case 3:
                    cze();
                    return;
                case 4:
                    czd();
                    return;
                case 5:
                    F(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    czf();
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void czc() {
        this.fBb.setVisibility(0);
        this.iVt.setVisibility(8);
        this.fBb.setText(this.iVp.getResources().getString(R.string.downloaded));
        ap.setViewTextColor(this.fBb, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_content_buy_d);
    }

    public void F(long j, long j2) {
        this.fBb.setVisibility(8);
        this.iVt.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.iVy);
        int i2 = i < this.iVx ? this.iVx : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iVu.getLayoutParams();
        layoutParams.width = i2;
        this.iVu.setLayoutParams(layoutParams);
    }

    public void czd() {
        this.fBb.setVisibility(0);
        this.iVt.setVisibility(8);
        this.fBb.setText(this.iVp.getResources().getString(R.string.buy_book));
        ap.setBackgroundResource(this.fBb, R.drawable.btn_all_blue);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cze() {
        this.fBb.setVisibility(0);
        this.iVt.setVisibility(8);
        this.fBb.setText(this.iVp.getResources().getString(R.string.can_download));
        ap.setViewTextColor(this.fBb, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_all_blue);
    }

    private void czf() {
        this.fBb.setVisibility(0);
        this.iVt.setVisibility(8);
        this.fBb.setText(this.iVp.getResources().getString(R.string.off_the_shelf));
        ap.setViewTextColor(this.fBb, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_content_buy_d);
    }

    public void czg() {
        if (this.iVC != null) {
            this.iVC.cyM();
            com.baidu.adp.lib.f.g.a(this.iVC, this.iVp);
        }
    }

    public void czh() {
        if (this.iVC != null) {
            this.iVC.cyN();
        }
    }

    public void czi() {
        if (this.iVC != null) {
            com.baidu.adp.lib.f.g.b(this.iVC, this.iVp);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iVp != null) {
            this.iVp.getLayoutMode().setNightMode(i == 1);
            this.iVp.getLayoutMode().onModeChanged(this.mParent);
        }
        if (this.iVq != null) {
            this.iVq.onChangeSkinType(this.iVp, i);
        }
        if (this.gyk != null) {
            this.gyk.onChangeSkinType(this.iVp, i);
        }
    }

    public void czj() {
        if (this.gyk != null && this.gyk.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gyk.update(false);
        }
    }

    public TextView czk() {
        return this.fBb;
    }

    public ImageView czl() {
        return this.iVv;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.iVG && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.iVG != -1) {
                O(this.iVG, false);
            }
            this.iVG = i;
            this.iVA.setSelection(i);
            O(i, true);
            this.iVE = true;
            this.iFP.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.iFP.setTag(str);
            if (com.baidu.tbadk.util.n.bFs()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.mHeight;
                gifInfo.mGifWidth = this.mWidth;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.iFP.a(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.mHeight;
                gifInfo2.mGifWidth = this.mWidth;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.iFP.a(gifInfo2);
            }
            this.iFO.x = rect.left - ((this.iFR - rect.width()) / 2);
            this.iFO.y = rect.top - this.iFO.height;
            if (this.iFO.y < this.cBN) {
                this.iVF.scrollBy(0, this.iFO.y - this.cBN);
                this.iFO.y = this.cBN;
            }
            this.iFO.y += this.iVA.getChildAt(i - this.iVA.getFirstVisiblePosition()).getPaddingTop();
            if (!this.iVD) {
                this.mWindowManager.addView(this.iFP, this.iFO);
                this.iVD = true;
                return;
            }
            this.mWindowManager.updateViewLayout(this.iFP, this.iFO);
        }
    }

    public boolean czm() {
        return this.iVE;
    }

    public void czn() {
        this.iVE = false;
        this.iFP.setVisibility(8);
        this.iVA.setSelection(-1);
        O(this.iVG, false);
        this.iVG = -1;
    }

    private void O(int i, boolean z) {
        ((ViewGroup) this.iVA.getChildAt(i - this.iVA.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void czo() {
        this.iVE = false;
        if (this.iVD) {
            this.iVD = false;
            this.mWindowManager.removeView(this.iFP);
        }
    }

    public GridView czp() {
        return this.iVA;
    }
}
