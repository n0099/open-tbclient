package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class s extends BaseAdapter {
    private static int mScreenWidth;
    private FaceBuyModel iTQ;
    private FaceShopData iUO;
    private final r iUP;
    private final int iUQ;
    private final int iUR;
    private FacePackageDownloadModel iUT;
    private final int mImageHeight;
    private final int mImageWidth;
    private int iUS = -1;
    View.OnClickListener iUU = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.s.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    int i = bVar.position;
                    if (!TbadkApplication.isLogin()) {
                        s.this.iUS = bVar.position;
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(s.this.iUP.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    } else {
                        switch (bVar.iVe) {
                            case 2:
                                s.this.zw(i);
                                break;
                            case 3:
                                s.this.zx(i);
                                break;
                            case 4:
                                s.this.zy(i);
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public int cBU() {
        return this.iUS;
    }

    public s(r rVar) {
        this.iUP = rVar;
        mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(rVar.getPageContext().getPageActivity());
        this.mImageWidth = mScreenWidth - (rVar.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.mImageHeight = (int) (this.mImageWidth * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.iUP.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.iUQ = resBitmap.getWidth();
        } else {
            this.iUQ = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.iUP.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.iUR = resBitmap2.getWidth();
        } else {
            this.iUR = 0;
        }
        this.iUT = null;
        this.iTQ = null;
    }

    public void a(FaceShopData faceShopData) {
        this.iUO = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iUO == null || this.iUO.pack_list == null) {
            return 0;
        }
        return this.iUO.pack_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iUO == null || this.iUO.pack_list == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.iUO.pack_list;
        if (i < 0 || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.iUO == null || this.iUO.pack_list == null || this.iUO.pack_list.get(i) == null) ? 2 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.getInst().getSkinType();
        if (view == null) {
            view = c(itemViewType, viewGroup);
        }
        a aVar = (a) view.getTag();
        com.baidu.tbadk.core.c layoutMode = this.iUP.getLayoutMode();
        layoutMode.setNightMode(skinType == 1);
        layoutMode.onModeChanged(view);
        a(i, aVar);
        a(aVar);
        a(aVar, skinType);
        return view;
    }

    public View c(int i, ViewGroup viewGroup) {
        if (i == 1) {
            a aVar = new a();
            View inflate = LayoutInflater.from(this.iUP.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
            aVar.iND = (TbImageView) inflate.findViewById(R.id.image);
            aVar.iUY = (FrameLayout) inflate.findViewById(R.id.btn);
            aVar.iUZ = (TextView) inflate.findViewById(R.id.btn_text);
            aVar.iVa = (TextView) inflate.findViewById(R.id.downloaded);
            aVar.iVb = (FrameLayout) inflate.findViewById(R.id.downloading);
            aVar.iUg = (ImageView) inflate.findViewById(R.id.downloading_up);
            aVar.gRm = (TextView) inflate.findViewById(R.id.intro);
            aVar.flJ = (TbImageView) inflate.findViewById(R.id.icon);
            aVar.flJ.setDefaultResource(0);
            aVar.flJ.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            layoutParams.setMargins(0, 0, 0, this.iUP.getResources().getDimensionPixelSize(R.dimen.ds8));
            aVar.iND.setLayoutParams(layoutParams);
            aVar.iUZ.setClickable(false);
            aVar.iUY.setClickable(true);
            aVar.iUY.setOnClickListener(this.iUU);
            aVar.iVc = (TbImageView) inflate.findViewById(R.id.title_tag);
            inflate.setTag(aVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, a aVar) {
        if (this.iUO != null && aVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    aVar.mPosition = i;
                    aVar.mTitle.setText(facePackageData.pname);
                    aVar.gRm.setText(facePackageData.pdesc);
                    aVar.iND.setTag(facePackageData.banner_url);
                    aVar.iND.a(facePackageData.banner_url, 10, this.mImageWidth, this.mImageHeight, false);
                    if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                        aVar.flJ.setTag(facePackageData.new_icon);
                        aVar.flJ.startLoad(facePackageData.new_icon, 21, false);
                        aVar.flJ.setVisibility(0);
                    } else {
                        aVar.flJ.setVisibility(8);
                    }
                    aVar.iVd = facePackageData.price;
                    a(facePackageData, aVar);
                    b bVar = new b();
                    bVar.iVe = aVar.iTU;
                    bVar.position = i;
                    aVar.iUY.setTag(bVar);
                    if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                        aVar.iVc.setVisibility(0);
                        aVar.iVc.setTag(facePackageData.tag_url);
                        aVar.iVc.startLoad(facePackageData.tag_url, 21, false);
                        return;
                    }
                    aVar.iVc.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            b(aVar);
            switch (aVar.iTU) {
                case 1:
                    aVar.iVa.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    aVar.iUY.setVisibility(0);
                    aVar.iUZ.setVisibility(0);
                    return;
                case 5:
                    aVar.iVb.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(a aVar, int i) {
        if (aVar != null) {
            if (aVar.iTU == 5) {
                e(aVar, i);
                return;
            }
            switch (aVar.iTU) {
                case 2:
                    c(aVar, i);
                    return;
                case 3:
                    b(aVar, i);
                    return;
                case 4:
                    d(aVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(a aVar, int i) {
        aVar.iUZ.setText(aVar.iVd);
        aVar.iUZ.setBackgroundResource(0);
        ao.setBackgroundResource(aVar.iUY, R.drawable.btn_all_white);
    }

    private void c(a aVar, int i) {
        aVar.iUZ.setText((CharSequence) null);
        ao.setBackgroundResource(aVar.iUY, R.drawable.btn_all_blue);
        ao.setBackgroundResource(aVar.iUZ, R.drawable.icon_content_download);
    }

    private void d(a aVar, int i) {
        aVar.iUZ.setText(aVar.iVd);
        aVar.iUZ.setBackgroundResource(0);
        ao.setBackgroundResource(aVar.iUY, R.drawable.faceshop_list_btn_selector);
    }

    private void e(a aVar, int i) {
        b(aVar);
        aVar.iVb.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(aVar.mPosition);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.iUQ);
            int i3 = i2 < this.iUR ? this.iUR : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.iUg.getLayoutParams();
            layoutParams.width = i3;
            aVar.iUg.setLayoutParams(layoutParams);
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.iUZ.setVisibility(8);
            aVar.iUY.setVisibility(8);
            aVar.iVa.setVisibility(8);
            aVar.iVb.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, a aVar) {
        if (facePackageData != null && aVar != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                aVar.iTU = 5;
            } else if (i3 == 1) {
                aVar.iTU = 1;
            } else if (i == 2) {
                aVar.iTU = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    aVar.iTU = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    aVar.iTU = 3;
                } else {
                    aVar.iTU = 4;
                }
            }
        }
    }

    public void zw(int i) {
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.iUT = new FacePackageDownloadModel(this.iUP.getPageContext().getContext());
            this.iUT.Kn(String.valueOf(facePackageData.pid));
            this.iUT.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        facePackageData.pack_url = facePackageDownloadData.pack_url;
                        f.cAY().aG(String.valueOf(facePackageData.pid), facePackageData.pname, facePackageData.pack_url);
                    } else if (facePackageDownloadData.usermsg != null) {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), facePackageDownloadData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    public void zx(int i) {
        TiebaStatic.log("emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public void zy(final int i) {
        TiebaStatic.log("emotion_package_list_buy");
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.iUO != null) {
            this.iUP.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.iTQ = new FaceBuyModel(this.iUP.getPageContext().getContext());
            this.iTQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    s.this.iUP.hideProgressBar();
                    if (obj == null || !(obj instanceof FaceBuyData)) {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status == 2) {
                            UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), R.string.has_buy_book);
                            facePackageData.buy_status = 1;
                            facePackageData.can_download = 1;
                            s.this.notifyDataSetChanged();
                            return;
                        }
                        facePackageData.orderId = faceBuyData.buy_info.order_id;
                        IntentConfig intentConfig = new IntentConfig(s.this.iUP);
                        intentConfig.getIntent().putExtra("tag_url", str);
                        intentConfig.getIntent().putExtra("tag_hook_url", str2);
                        intentConfig.getIntent().putExtra("tag_title", s.this.iUP.getString(R.string.buy_book));
                        intentConfig.getIntent().putExtra("tag_position", i);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                    } else if (faceBuyData.usermsg != null) {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), faceBuyData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iUP.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
            this.iTQ.Kh(valueOf);
        }
    }

    public void onDestroy() {
        if (this.iTQ != null) {
            this.iTQ.cancelLoadData();
        }
        if (this.iUT != null) {
            this.iUT.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b {
        int iVe;
        int position;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        TbImageView flJ;
        TextView gRm;
        TbImageView iND;
        int iTU;
        FrameLayout iUY;
        TextView iUZ;
        ImageView iUg;
        TextView iVa;
        FrameLayout iVb;
        TbImageView iVc;
        String iVd;
        int mPosition;
        TextView mTitle;

        private a() {
        }
    }
}
