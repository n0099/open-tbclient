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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes8.dex */
public class m {
    private TextView bIw;
    private int czr;
    private final TextView fha;
    private final TextView fyM;
    private final TbImageView gCr;
    private final NoNetworkView gvm;
    private final ImageView iPA;
    private TextView iPB;
    private final int iPC;
    private final int iPD;
    private final int iPE;
    private final GridView iPF;
    private n iPG;
    private final j iPH;
    private boolean iPI;
    private boolean iPJ;
    private final ScrollView iPK;
    private final TbImageView iPM;
    private final TbPageContext<l> iPu;
    private final NavigationBar iPv;
    private final TextView iPw;
    private final TextView iPx;
    private final FrameLayout iPy;
    private final ImageView iPz;
    private WindowManager.LayoutParams izQ;
    private GifView izR;
    private int izT;
    private int izU;
    private final LinearLayout mContainer;
    private final Handler mHandler;
    private int mHeight;
    private final View mParent;
    private final int mSkinType;
    private final TextView mTitle;
    private int mWidth;
    private WindowManager mWindowManager;
    private int iPL = -1;
    private final Runnable iPN = new Runnable() { // from class: com.baidu.tieba.faceshop.m.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.VH();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    };

    public m(TbPageContext<l> tbPageContext) {
        this.iPu = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        this.iPv = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iPv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bIw = this.iPv.setTitleText("");
        this.gvm = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.mContainer = (LinearLayout) this.mParent.findViewById(R.id.face_package_container);
        this.iPB = (TextView) this.mParent.findViewById(R.id.top_view);
        ((LinearLayout.LayoutParams) this.iPB.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iPu.getPageActivity(), R.dimen.ds98);
        this.gCr = (TbImageView) this.mParent.findViewById(R.id.face_package_cover);
        this.mTitle = (TextView) this.mParent.findViewById(R.id.face_package_title);
        this.fha = (TextView) this.mParent.findViewById(R.id.face_package_price);
        this.iPw = (TextView) this.mParent.findViewById(R.id.face_package_status);
        this.fyM = (TextView) this.mParent.findViewById(R.id.face_package_btn);
        this.iPx = (TextView) this.mParent.findViewById(R.id.face_package_info);
        this.iPF = (GridView) this.mParent.findViewById(R.id.face_package_faces);
        this.iPM = (TbImageView) this.mParent.findViewById(R.id.face_package_title_tag);
        this.iPM.setDefaultResource(0);
        this.iPM.setDefaultBgResource(0);
        this.iPF.setSelection(-1);
        try {
            this.iPF.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iPF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.m.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m.this.iPF.setSelection(-1);
            }
        });
        this.iPy = (FrameLayout) this.mParent.findViewById(R.id.face_package_downloading);
        this.iPz = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_up);
        this.iPA = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        this.mWidth = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHeight = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHandler = new Handler();
        this.fyM.setOnClickListener(tbPageContext.getOrignalPage());
        this.iPA.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.iPD = cashBitmap.getWidth();
        this.iPC = cashBitmap2.getWidth();
        this.iPE = this.iPu.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.iPH = new j(this.iPu, R.style.common_alert_dialog);
        this.iPK = (ScrollView) this.mParent.findViewById(R.id.container_scrollview);
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.izR = new GifView(tbPageContext.getPageActivity());
        ao.setBackgroundResource(this.izR, R.drawable.bg_expression_bubble);
        this.izR.setVisibility(8);
        this.izR.setSupportNoImage(false);
        this.mWindowManager = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.izQ = new WindowManager.LayoutParams();
        this.izT = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        this.izU = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.izQ.width = this.izT;
        this.izQ.height = this.izU;
        this.izQ.gravity = 51;
        this.izQ.format = -3;
        this.izQ.type = 1000;
        this.izQ.flags |= 56;
        this.czr = com.baidu.adp.lib.util.l.getStatusBarHeight(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            this.izQ.type = 1000;
            this.izQ.flags = 25165832;
        }
    }

    public void g(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null) {
            h(facePackageDetailModel);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.iPF.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.iPu.getPageActivity()) - (this.iPE * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void Jb(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.iPG == null) {
                this.iPG = new n(this.iPu.getPageActivity(), facePackageData.face_list);
                this.iPF.setAdapter((ListAdapter) this.iPG);
                return;
            }
            this.iPG.setData(facePackageData.face_list);
            this.iPG.notifyDataSetChanged();
        }
    }

    public void h(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel != null && facePackageDetailModel.cxE() != null && (facePackageData = facePackageDetailModel.cxE().faces_list) != null) {
            if (facePackageDetailModel.cxG()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.mContainer.setVisibility(0);
            this.gCr.setTag(facePackageData.cover_url);
            this.mTitle.setText(facePackageData.pname);
            this.iPM.setTag(facePackageData.tag_url);
            this.fha.setText(this.iPu.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.iPx.setText(facePackageData.pdesc);
            this.bIw.setText(facePackageData.pname);
            b(facePackageData);
            Jb(facePackageDetailModel.getPid());
            c(facePackageData);
            cxJ();
        }
    }

    private void cxJ() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iPN);
            this.mHandler.postDelayed(this.iPN, 90L);
        }
    }

    public void VH() {
        if (this.gCr != null && this.gCr.getTag() != null) {
            this.gCr.a(this.gCr.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.iPM != null && this.iPM.getTag() != null) {
            this.iPM.a(this.iPM.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void pY(boolean z) {
        BdListViewHelper.a(this.iPB, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c(NoNetworkView.a aVar) {
        this.gvm.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gvm.b(aVar);
    }

    public void i(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null && facePackageDetailModel.cxE() != null && facePackageDetailModel.cxE().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.cxE().faces_list;
            if (facePackageData.buy_status == 1) {
                this.iPw.setText(this.iPu.getResources().getString(R.string.has_buy));
                this.iPw.setVisibility(0);
            } else {
                this.iPw.setVisibility(8);
            }
            switch (facePackageDetailModel.cxH()) {
                case 1:
                    cxK();
                    return;
                case 2:
                case 3:
                    cxM();
                    return;
                case 4:
                    cxL();
                    return;
                case 5:
                    B(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    cxN();
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void cxK() {
        this.fyM.setVisibility(0);
        this.iPy.setVisibility(8);
        this.fyM.setText(this.iPu.getResources().getString(R.string.downloaded));
        ao.setViewTextColor(this.fyM, R.color.common_color_10172, 1);
        ao.setBackgroundResource(this.fyM, R.drawable.btn_content_buy_d);
    }

    public void B(long j, long j2) {
        this.fyM.setVisibility(8);
        this.iPy.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.iPD);
        int i2 = i < this.iPC ? this.iPC : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iPz.getLayoutParams();
        layoutParams.width = i2;
        this.iPz.setLayoutParams(layoutParams);
    }

    public void cxL() {
        this.fyM.setVisibility(0);
        this.iPy.setVisibility(8);
        this.fyM.setText(this.iPu.getResources().getString(R.string.buy_book));
        ao.setBackgroundResource(this.fyM, R.drawable.btn_all_blue);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cxM() {
        this.fyM.setVisibility(0);
        this.iPy.setVisibility(8);
        this.fyM.setText(this.iPu.getResources().getString(R.string.can_download));
        ao.setViewTextColor(this.fyM, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.fyM, R.drawable.btn_all_blue);
    }

    private void cxN() {
        this.fyM.setVisibility(0);
        this.iPy.setVisibility(8);
        this.fyM.setText(this.iPu.getResources().getString(R.string.off_the_shelf));
        ao.setViewTextColor(this.fyM, R.color.common_color_10172, 1);
        ao.setBackgroundResource(this.fyM, R.drawable.btn_content_buy_d);
    }

    public void cxO() {
        if (this.iPH != null) {
            this.iPH.cxu();
            com.baidu.adp.lib.f.g.a(this.iPH, this.iPu);
        }
    }

    public void cxP() {
        if (this.iPH != null) {
            this.iPH.cxv();
        }
    }

    public void cxQ() {
        if (this.iPH != null) {
            com.baidu.adp.lib.f.g.b(this.iPH, this.iPu);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iPu != null) {
            this.iPu.getLayoutMode().setNightMode(i == 1);
            this.iPu.getLayoutMode().onModeChanged(this.mParent);
        }
        if (this.iPv != null) {
            this.iPv.onChangeSkinType(this.iPu, i);
        }
        if (this.gvm != null) {
            this.gvm.onChangeSkinType(this.iPu, i);
        }
    }

    public void cxR() {
        if (this.gvm != null && this.gvm.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gvm.update(false);
        }
    }

    public TextView cxS() {
        return this.fyM;
    }

    public ImageView cxT() {
        return this.iPA;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.iPL && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.iPL != -1) {
                O(this.iPL, false);
            }
            this.iPL = i;
            this.iPF.setSelection(i);
            O(i, true);
            this.iPJ = true;
            this.izR.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.izR.setTag(str);
            if (com.baidu.tbadk.util.m.bEZ()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.mHeight;
                gifInfo.mGifWidth = this.mWidth;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.izR.a(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.mHeight;
                gifInfo2.mGifWidth = this.mWidth;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.izR.a(gifInfo2);
            }
            this.izQ.x = rect.left - ((this.izT - rect.width()) / 2);
            this.izQ.y = rect.top - this.izQ.height;
            if (this.izQ.y < this.czr) {
                this.iPK.scrollBy(0, this.izQ.y - this.czr);
                this.izQ.y = this.czr;
            }
            this.izQ.y += this.iPF.getChildAt(i - this.iPF.getFirstVisiblePosition()).getPaddingTop();
            if (!this.iPI) {
                this.mWindowManager.addView(this.izR, this.izQ);
                this.iPI = true;
                return;
            }
            this.mWindowManager.updateViewLayout(this.izR, this.izQ);
        }
    }

    public boolean cxU() {
        return this.iPJ;
    }

    public void cxV() {
        this.iPJ = false;
        this.izR.setVisibility(8);
        this.iPF.setSelection(-1);
        O(this.iPL, false);
        this.iPL = -1;
    }

    private void O(int i, boolean z) {
        ((ViewGroup) this.iPF.getChildAt(i - this.iPF.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void cxW() {
        this.iPJ = false;
        if (this.iPI) {
            this.iPI = false;
            this.mWindowManager.removeView(this.izR);
        }
    }

    public GridView cxX() {
        return this.iPF;
    }
}
