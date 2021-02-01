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
    private final TbImageView gFb;
    private final NoNetworkView gxW;
    private WindowManager.LayoutParams iFA;
    private GifView iFB;
    private int iFD;
    private int iFE;
    private final TbPageContext<l> iVb;
    private final NavigationBar iVc;
    private final TextView iVd;
    private final TextView iVe;
    private final FrameLayout iVf;
    private final ImageView iVg;
    private final ImageView iVh;
    private TextView iVi;
    private final int iVj;
    private final int iVk;
    private final int iVl;
    private final GridView iVm;
    private n iVn;
    private final j iVo;
    private boolean iVp;
    private boolean iVq;
    private final ScrollView iVr;
    private final TbImageView iVt;
    private final LinearLayout mContainer;
    private final Handler mHandler;
    private int mHeight;
    private final View mParent;
    private final int mSkinType;
    private final TextView mTitle;
    private int mWidth;
    private WindowManager mWindowManager;
    private int iVs = -1;
    private final Runnable iVu = new Runnable() { // from class: com.baidu.tieba.faceshop.m.2
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
        this.iVb = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        this.iVc = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iVc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bMg = this.iVc.setTitleText("");
        this.gxW = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.mContainer = (LinearLayout) this.mParent.findViewById(R.id.face_package_container);
        this.iVi = (TextView) this.mParent.findViewById(R.id.top_view);
        ((LinearLayout.LayoutParams) this.iVi.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iVb.getPageActivity(), R.dimen.ds98);
        this.gFb = (TbImageView) this.mParent.findViewById(R.id.face_package_cover);
        this.mTitle = (TextView) this.mParent.findViewById(R.id.face_package_title);
        this.fjt = (TextView) this.mParent.findViewById(R.id.face_package_price);
        this.iVd = (TextView) this.mParent.findViewById(R.id.face_package_status);
        this.fBb = (TextView) this.mParent.findViewById(R.id.face_package_btn);
        this.iVe = (TextView) this.mParent.findViewById(R.id.face_package_info);
        this.iVm = (GridView) this.mParent.findViewById(R.id.face_package_faces);
        this.iVt = (TbImageView) this.mParent.findViewById(R.id.face_package_title_tag);
        this.iVt.setDefaultResource(0);
        this.iVt.setDefaultBgResource(0);
        this.iVm.setSelection(-1);
        try {
            this.iVm.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iVm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.m.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m.this.iVm.setSelection(-1);
            }
        });
        this.iVf = (FrameLayout) this.mParent.findViewById(R.id.face_package_downloading);
        this.iVg = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_up);
        this.iVh = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        this.mWidth = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHeight = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHandler = new Handler();
        this.fBb.setOnClickListener(tbPageContext.getOrignalPage());
        this.iVh.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.iVk = cashBitmap.getWidth();
        this.iVj = cashBitmap2.getWidth();
        this.iVl = this.iVb.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.iVo = new j(this.iVb, R.style.common_alert_dialog);
        this.iVr = (ScrollView) this.mParent.findViewById(R.id.container_scrollview);
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.iFB = new GifView(tbPageContext.getPageActivity());
        ap.setBackgroundResource(this.iFB, R.drawable.bg_expression_bubble);
        this.iFB.setVisibility(8);
        this.iFB.setSupportNoImage(false);
        this.mWindowManager = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.iFA = new WindowManager.LayoutParams();
        this.iFD = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        this.iFE = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iFA.width = this.iFD;
        this.iFA.height = this.iFE;
        this.iFA.gravity = 51;
        this.iFA.format = -3;
        this.iFA.type = 1000;
        this.iFA.flags |= 56;
        this.cBN = com.baidu.adp.lib.util.l.getStatusBarHeight(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            this.iFA.type = 1000;
            this.iFA.flags = 25165832;
        }
    }

    public void g(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null) {
            h(facePackageDetailModel);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.iVm.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.iVb.getPageActivity()) - (this.iVl * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void JM(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.iVn == null) {
                this.iVn = new n(this.iVb.getPageActivity(), facePackageData.face_list);
                this.iVm.setAdapter((ListAdapter) this.iVn);
                return;
            }
            this.iVn.setData(facePackageData.face_list);
            this.iVn.notifyDataSetChanged();
        }
    }

    public void h(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel != null && facePackageDetailModel.cyP() != null && (facePackageData = facePackageDetailModel.cyP().faces_list) != null) {
            if (facePackageDetailModel.cyR()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.mContainer.setVisibility(0);
            this.gFb.setTag(facePackageData.cover_url);
            this.mTitle.setText(facePackageData.pname);
            this.iVt.setTag(facePackageData.tag_url);
            this.fjt.setText(this.iVb.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.iVe.setText(facePackageData.pdesc);
            this.bMg.setText(facePackageData.pname);
            b(facePackageData);
            JM(facePackageDetailModel.getPid());
            c(facePackageData);
            cyU();
        }
    }

    private void cyU() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iVu);
            this.mHandler.postDelayed(this.iVu, 90L);
        }
    }

    public void Xq() {
        if (this.gFb != null && this.gFb.getTag() != null) {
            this.gFb.a(this.gFb.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.iVt != null && this.iVt.getTag() != null) {
            this.iVt.a(this.iVt.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iVi, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c(NoNetworkView.a aVar) {
        this.gxW.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gxW.b(aVar);
    }

    public void i(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null && facePackageDetailModel.cyP() != null && facePackageDetailModel.cyP().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.cyP().faces_list;
            if (facePackageData.buy_status == 1) {
                this.iVd.setText(this.iVb.getResources().getString(R.string.has_buy));
                this.iVd.setVisibility(0);
            } else {
                this.iVd.setVisibility(8);
            }
            switch (facePackageDetailModel.cyS()) {
                case 1:
                    cyV();
                    return;
                case 2:
                case 3:
                    cyX();
                    return;
                case 4:
                    cyW();
                    return;
                case 5:
                    F(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    cyY();
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void cyV() {
        this.fBb.setVisibility(0);
        this.iVf.setVisibility(8);
        this.fBb.setText(this.iVb.getResources().getString(R.string.downloaded));
        ap.setViewTextColor(this.fBb, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_content_buy_d);
    }

    public void F(long j, long j2) {
        this.fBb.setVisibility(8);
        this.iVf.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.iVk);
        int i2 = i < this.iVj ? this.iVj : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iVg.getLayoutParams();
        layoutParams.width = i2;
        this.iVg.setLayoutParams(layoutParams);
    }

    public void cyW() {
        this.fBb.setVisibility(0);
        this.iVf.setVisibility(8);
        this.fBb.setText(this.iVb.getResources().getString(R.string.buy_book));
        ap.setBackgroundResource(this.fBb, R.drawable.btn_all_blue);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cyX() {
        this.fBb.setVisibility(0);
        this.iVf.setVisibility(8);
        this.fBb.setText(this.iVb.getResources().getString(R.string.can_download));
        ap.setViewTextColor(this.fBb, R.color.CAM_X0101, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_all_blue);
    }

    private void cyY() {
        this.fBb.setVisibility(0);
        this.iVf.setVisibility(8);
        this.fBb.setText(this.iVb.getResources().getString(R.string.off_the_shelf));
        ap.setViewTextColor(this.fBb, R.color.common_color_10172, 1);
        ap.setBackgroundResource(this.fBb, R.drawable.btn_content_buy_d);
    }

    public void cyZ() {
        if (this.iVo != null) {
            this.iVo.cyF();
            com.baidu.adp.lib.f.g.a(this.iVo, this.iVb);
        }
    }

    public void cza() {
        if (this.iVo != null) {
            this.iVo.cyG();
        }
    }

    public void czb() {
        if (this.iVo != null) {
            com.baidu.adp.lib.f.g.b(this.iVo, this.iVb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iVb != null) {
            this.iVb.getLayoutMode().setNightMode(i == 1);
            this.iVb.getLayoutMode().onModeChanged(this.mParent);
        }
        if (this.iVc != null) {
            this.iVc.onChangeSkinType(this.iVb, i);
        }
        if (this.gxW != null) {
            this.gxW.onChangeSkinType(this.iVb, i);
        }
    }

    public void czc() {
        if (this.gxW != null && this.gxW.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gxW.update(false);
        }
    }

    public TextView czd() {
        return this.fBb;
    }

    public ImageView cze() {
        return this.iVh;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.iVs && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.iVs != -1) {
                O(this.iVs, false);
            }
            this.iVs = i;
            this.iVm.setSelection(i);
            O(i, true);
            this.iVq = true;
            this.iFB.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.iFB.setTag(str);
            if (com.baidu.tbadk.util.n.bFs()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.mHeight;
                gifInfo.mGifWidth = this.mWidth;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.iFB.a(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.mHeight;
                gifInfo2.mGifWidth = this.mWidth;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.iFB.a(gifInfo2);
            }
            this.iFA.x = rect.left - ((this.iFD - rect.width()) / 2);
            this.iFA.y = rect.top - this.iFA.height;
            if (this.iFA.y < this.cBN) {
                this.iVr.scrollBy(0, this.iFA.y - this.cBN);
                this.iFA.y = this.cBN;
            }
            this.iFA.y += this.iVm.getChildAt(i - this.iVm.getFirstVisiblePosition()).getPaddingTop();
            if (!this.iVp) {
                this.mWindowManager.addView(this.iFB, this.iFA);
                this.iVp = true;
                return;
            }
            this.mWindowManager.updateViewLayout(this.iFB, this.iFA);
        }
    }

    public boolean czf() {
        return this.iVq;
    }

    public void czg() {
        this.iVq = false;
        this.iFB.setVisibility(8);
        this.iVm.setSelection(-1);
        O(this.iVs, false);
        this.iVs = -1;
    }

    private void O(int i, boolean z) {
        ((ViewGroup) this.iVm.getChildAt(i - this.iVm.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void czh() {
        this.iVq = false;
        if (this.iVp) {
            this.iVp = false;
            this.mWindowManager.removeView(this.iFB);
        }
    }

    public GridView czi() {
        return this.iVm;
    }
}
