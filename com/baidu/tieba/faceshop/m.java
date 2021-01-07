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
/* loaded from: classes9.dex */
public class m {
    private TextView bNi;
    private int cEd;
    private final TextView fDu;
    private final TextView flL;
    private final TbImageView gGX;
    private final NoNetworkView gzT;
    private int iEA;
    private int iEB;
    private WindowManager.LayoutParams iEx;
    private GifView iEy;
    private final TbPageContext<l> iUb;
    private final NavigationBar iUc;
    private final TextView iUd;
    private final TextView iUe;
    private final FrameLayout iUf;
    private final ImageView iUg;
    private final ImageView iUh;
    private TextView iUi;
    private final int iUj;
    private final int iUk;
    private final int iUl;
    private final GridView iUm;
    private n iUn;
    private final j iUo;
    private boolean iUp;
    private boolean iUq;
    private final ScrollView iUr;
    private final TbImageView iUt;
    private final LinearLayout mContainer;
    private final Handler mHandler;
    private int mHeight;
    private final View mParent;
    private final int mSkinType;
    private final TextView mTitle;
    private int mWidth;
    private WindowManager mWindowManager;
    private int iUs = -1;
    private final Runnable iUu = new Runnable() { // from class: com.baidu.tieba.faceshop.m.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                m.this.ZA();
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    };

    public m(TbPageContext<l> tbPageContext) {
        this.iUb = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        this.iUc = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.iUc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNi = this.iUc.setTitleText("");
        this.gzT = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.mContainer = (LinearLayout) this.mParent.findViewById(R.id.face_package_container);
        this.iUi = (TextView) this.mParent.findViewById(R.id.top_view);
        ((LinearLayout.LayoutParams) this.iUi.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iUb.getPageActivity(), R.dimen.ds98);
        this.gGX = (TbImageView) this.mParent.findViewById(R.id.face_package_cover);
        this.mTitle = (TextView) this.mParent.findViewById(R.id.face_package_title);
        this.flL = (TextView) this.mParent.findViewById(R.id.face_package_price);
        this.iUd = (TextView) this.mParent.findViewById(R.id.face_package_status);
        this.fDu = (TextView) this.mParent.findViewById(R.id.face_package_btn);
        this.iUe = (TextView) this.mParent.findViewById(R.id.face_package_info);
        this.iUm = (GridView) this.mParent.findViewById(R.id.face_package_faces);
        this.iUt = (TbImageView) this.mParent.findViewById(R.id.face_package_title_tag);
        this.iUt.setDefaultResource(0);
        this.iUt.setDefaultBgResource(0);
        this.iUm.setSelection(-1);
        try {
            this.iUm.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.iUm.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.faceshop.m.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                m.this.iUm.setSelection(-1);
            }
        });
        this.iUf = (FrameLayout) this.mParent.findViewById(R.id.face_package_downloading);
        this.iUg = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_up);
        this.iUh = (ImageView) this.mParent.findViewById(R.id.face_package_downloading_cancel);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        this.mWidth = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHeight = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.mHandler = new Handler();
        this.fDu.setOnClickListener(tbPageContext.getOrignalPage());
        this.iUh.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.iUk = cashBitmap.getWidth();
        this.iUj = cashBitmap2.getWidth();
        this.iUl = this.iUb.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.iUo = new j(this.iUb, R.style.common_alert_dialog);
        this.iUr = (ScrollView) this.mParent.findViewById(R.id.container_scrollview);
        r(tbPageContext);
    }

    private void r(TbPageContext<?> tbPageContext) {
        this.iEy = new GifView(tbPageContext.getPageActivity());
        ao.setBackgroundResource(this.iEy, R.drawable.bg_expression_bubble);
        this.iEy.setVisibility(8);
        this.iEy.setSupportNoImage(false);
        this.mWindowManager = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.iEx = new WindowManager.LayoutParams();
        this.iEA = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        this.iEB = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.iEx.width = this.iEA;
        this.iEx.height = this.iEB;
        this.iEx.gravity = 51;
        this.iEx.format = -3;
        this.iEx.type = 1000;
        this.iEx.flags |= 56;
        this.cEd = com.baidu.adp.lib.util.l.getStatusBarHeight(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            this.iEx.type = 1000;
            this.iEx.flags = 25165832;
        }
    }

    public void g(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null) {
            h(facePackageDetailModel);
        }
    }

    private void b(FacePackageData facePackageData) {
        if (facePackageData != null && facePackageData.face_list != null) {
            this.iUm.setLayoutParams(new LinearLayout.LayoutParams(-1, ((com.baidu.adp.lib.util.l.getEquipmentWidth(this.iUb.getPageActivity()) - (this.iUl * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
        }
    }

    public void Km(String str) {
        if (str != null && str.length() > 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
        }
    }

    public void c(FacePackageData facePackageData) {
        if (facePackageData != null) {
            if (this.iUn == null) {
                this.iUn = new n(this.iUb.getPageActivity(), facePackageData.face_list);
                this.iUm.setAdapter((ListAdapter) this.iUn);
                return;
            }
            this.iUn.setData(facePackageData.face_list);
            this.iUn.notifyDataSetChanged();
        }
    }

    public void h(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel != null && facePackageDetailModel.cBw() != null && (facePackageData = facePackageDetailModel.cBw().faces_list) != null) {
            if (facePackageDetailModel.cBy()) {
                facePackageData.downloading = 1;
            } else {
                facePackageData.downloading = 0;
            }
            this.mContainer.setVisibility(0);
            this.gGX.setTag(facePackageData.cover_url);
            this.mTitle.setText(facePackageData.pname);
            this.iUt.setTag(facePackageData.tag_url);
            this.flL.setText(this.iUb.getResources().getString(R.string.price_tip) + facePackageData.price);
            this.iUe.setText(facePackageData.pdesc);
            this.bNi.setText(facePackageData.pname);
            b(facePackageData);
            Km(facePackageDetailModel.getPid());
            c(facePackageData);
            cBB();
        }
    }

    private void cBB() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.iUu);
            this.mHandler.postDelayed(this.iUu, 90L);
        }
    }

    public void ZA() {
        if (this.gGX != null && this.gGX.getTag() != null) {
            this.gGX.a(this.gGX.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
        if (this.iUt != null && this.iUt.getTag() != null) {
            this.iUt.a(this.iUt.getTag().toString(), 10, this.mWidth, this.mHeight, false);
        }
    }

    public void qc(boolean z) {
        BdListViewHelper.a(this.iUi, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void c(NoNetworkView.a aVar) {
        this.gzT.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gzT.b(aVar);
    }

    public void i(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel != null && facePackageDetailModel.cBw() != null && facePackageDetailModel.cBw().faces_list != null) {
            FacePackageData facePackageData = facePackageDetailModel.cBw().faces_list;
            if (facePackageData.buy_status == 1) {
                this.iUd.setText(this.iUb.getResources().getString(R.string.has_buy));
                this.iUd.setVisibility(0);
            } else {
                this.iUd.setVisibility(8);
            }
            switch (facePackageDetailModel.cBz()) {
                case 1:
                    cBC();
                    return;
                case 2:
                case 3:
                    cBE();
                    return;
                case 4:
                    cBD();
                    return;
                case 5:
                    B(facePackageData.downloadTotal, facePackageData.downloadNow);
                    return;
                case 6:
                    cBF();
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void cBC() {
        this.fDu.setVisibility(0);
        this.iUf.setVisibility(8);
        this.fDu.setText(this.iUb.getResources().getString(R.string.downloaded));
        ao.setViewTextColor(this.fDu, R.color.common_color_10172, 1);
        ao.setBackgroundResource(this.fDu, R.drawable.btn_content_buy_d);
    }

    public void B(long j, long j2) {
        this.fDu.setVisibility(8);
        this.iUf.setVisibility(0);
        int i = (int) ((((float) j2) / ((float) j)) * this.iUk);
        int i2 = i < this.iUj ? this.iUj : i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iUg.getLayoutParams();
        layoutParams.width = i2;
        this.iUg.setLayoutParams(layoutParams);
    }

    public void cBD() {
        this.fDu.setVisibility(0);
        this.iUf.setVisibility(8);
        this.fDu.setText(this.iUb.getResources().getString(R.string.buy_book));
        ao.setBackgroundResource(this.fDu, R.drawable.btn_all_blue);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cBE() {
        this.fDu.setVisibility(0);
        this.iUf.setVisibility(8);
        this.fDu.setText(this.iUb.getResources().getString(R.string.can_download));
        ao.setViewTextColor(this.fDu, R.color.CAM_X0101, 1);
        ao.setBackgroundResource(this.fDu, R.drawable.btn_all_blue);
    }

    private void cBF() {
        this.fDu.setVisibility(0);
        this.iUf.setVisibility(8);
        this.fDu.setText(this.iUb.getResources().getString(R.string.off_the_shelf));
        ao.setViewTextColor(this.fDu, R.color.common_color_10172, 1);
        ao.setBackgroundResource(this.fDu, R.drawable.btn_content_buy_d);
    }

    public void cBG() {
        if (this.iUo != null) {
            this.iUo.cBm();
            com.baidu.adp.lib.f.g.a(this.iUo, this.iUb);
        }
    }

    public void cBH() {
        if (this.iUo != null) {
            this.iUo.cBn();
        }
    }

    public void cBI() {
        if (this.iUo != null) {
            com.baidu.adp.lib.f.g.b(this.iUo, this.iUb);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUb != null) {
            this.iUb.getLayoutMode().setNightMode(i == 1);
            this.iUb.getLayoutMode().onModeChanged(this.mParent);
        }
        if (this.iUc != null) {
            this.iUc.onChangeSkinType(this.iUb, i);
        }
        if (this.gzT != null) {
            this.gzT.onChangeSkinType(this.iUb, i);
        }
    }

    public void cBJ() {
        if (this.gzT != null && this.gzT.getVisibility() == 0 && com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            this.gzT.update(false);
        }
    }

    public TextView cBK() {
        return this.fDu;
    }

    public ImageView cBL() {
        return this.iUh;
    }

    public void a(int i, Rect rect, FacePackageData facePackageData) {
        if (i != this.iUs && facePackageData.face_dynamic_list != null && i >= 0 && i <= facePackageData.face_dynamic_list.size()) {
            if (this.iUs != -1) {
                O(this.iUs, false);
            }
            this.iUs = i;
            this.iUm.setSelection(i);
            O(i, true);
            this.iUq = true;
            this.iEy.setVisibility(0);
            String str = "#(" + facePackageData.face_dynamic_list.get(i) + ")";
            this.iEy.setTag(str);
            if (com.baidu.tbadk.util.m.bIR()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.mHeight;
                gifInfo.mGifWidth = this.mWidth;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.iEy.a(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.mHeight;
                gifInfo2.mGifWidth = this.mWidth;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.iEy.a(gifInfo2);
            }
            this.iEx.x = rect.left - ((this.iEA - rect.width()) / 2);
            this.iEx.y = rect.top - this.iEx.height;
            if (this.iEx.y < this.cEd) {
                this.iUr.scrollBy(0, this.iEx.y - this.cEd);
                this.iEx.y = this.cEd;
            }
            this.iEx.y += this.iUm.getChildAt(i - this.iUm.getFirstVisiblePosition()).getPaddingTop();
            if (!this.iUp) {
                this.mWindowManager.addView(this.iEy, this.iEx);
                this.iUp = true;
                return;
            }
            this.mWindowManager.updateViewLayout(this.iEy, this.iEx);
        }
    }

    public boolean cBM() {
        return this.iUq;
    }

    public void cBN() {
        this.iUq = false;
        this.iEy.setVisibility(8);
        this.iUm.setSelection(-1);
        O(this.iUs, false);
        this.iUs = -1;
    }

    private void O(int i, boolean z) {
        ((ViewGroup) this.iUm.getChildAt(i - this.iUm.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void cBO() {
        this.iUq = false;
        if (this.iUp) {
            this.iUp = false;
            this.mWindowManager.removeView(this.iEy);
        }
    }

    public GridView cBP() {
        return this.iUm;
    }
}
