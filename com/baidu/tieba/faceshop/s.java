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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class s extends BaseAdapter {
    private static int mScreenWidth;
    private FaceBuyModel iWN;
    private FaceShopData iXL;
    private final r iXM;
    private final int iXN;
    private final int iXO;
    private FacePackageDownloadModel iXQ;
    private final int mImageHeight;
    private final int mImageWidth;
    private int iXP = -1;
    View.OnClickListener iXR = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.s.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    int i = bVar.position;
                    if (!TbadkApplication.isLogin()) {
                        s.this.iXP = bVar.position;
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(s.this.iXM.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    } else {
                        switch (bVar.iYb) {
                            case 2:
                                s.this.yb(i);
                                break;
                            case 3:
                                s.this.yc(i);
                                break;
                            case 4:
                                s.this.yd(i);
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public int czA() {
        return this.iXP;
    }

    public s(r rVar) {
        this.iXM = rVar;
        mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(rVar.getPageContext().getPageActivity());
        this.mImageWidth = mScreenWidth - (rVar.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.mImageHeight = (int) (this.mImageWidth * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.iXM.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.iXN = resBitmap.getWidth();
        } else {
            this.iXN = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.iXM.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.iXO = resBitmap2.getWidth();
        } else {
            this.iXO = 0;
        }
        this.iXQ = null;
        this.iWN = null;
    }

    public void a(FaceShopData faceShopData) {
        this.iXL = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iXL == null || this.iXL.pack_list == null) {
            return 0;
        }
        return this.iXL.pack_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iXL == null || this.iXL.pack_list == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.iXL.pack_list;
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
        return (this.iXL == null || this.iXL.pack_list == null || this.iXL.pack_list.get(i) == null) ? 2 : 1;
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
        com.baidu.tbadk.core.c layoutMode = this.iXM.getLayoutMode();
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
            View inflate = LayoutInflater.from(this.iXM.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
            aVar.iQB = (TbImageView) inflate.findViewById(R.id.image);
            aVar.iXV = (FrameLayout) inflate.findViewById(R.id.btn);
            aVar.iXW = (TextView) inflate.findViewById(R.id.btn_text);
            aVar.iXX = (TextView) inflate.findViewById(R.id.downloaded);
            aVar.iXY = (FrameLayout) inflate.findViewById(R.id.downloading);
            aVar.iXd = (ImageView) inflate.findViewById(R.id.downloading_up);
            aVar.gRj = (TextView) inflate.findViewById(R.id.intro);
            aVar.fkQ = (TbImageView) inflate.findViewById(R.id.icon);
            aVar.fkQ.setDefaultResource(0);
            aVar.fkQ.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            layoutParams.setMargins(0, 0, 0, this.iXM.getResources().getDimensionPixelSize(R.dimen.ds8));
            aVar.iQB.setLayoutParams(layoutParams);
            aVar.iXW.setClickable(false);
            aVar.iXV.setClickable(true);
            aVar.iXV.setOnClickListener(this.iXR);
            aVar.iXZ = (TbImageView) inflate.findViewById(R.id.title_tag);
            inflate.setTag(aVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, a aVar) {
        if (this.iXL != null && aVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    aVar.mPosition = i;
                    aVar.mTitle.setText(facePackageData.pname);
                    aVar.gRj.setText(facePackageData.pdesc);
                    aVar.iQB.setTag(facePackageData.banner_url);
                    aVar.iQB.a(facePackageData.banner_url, 10, this.mImageWidth, this.mImageHeight, false);
                    if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                        aVar.fkQ.setTag(facePackageData.new_icon);
                        aVar.fkQ.startLoad(facePackageData.new_icon, 21, false);
                        aVar.fkQ.setVisibility(0);
                    } else {
                        aVar.fkQ.setVisibility(8);
                    }
                    aVar.iYa = facePackageData.price;
                    a(facePackageData, aVar);
                    b bVar = new b();
                    bVar.iYb = aVar.iWR;
                    bVar.position = i;
                    aVar.iXV.setTag(bVar);
                    if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                        aVar.iXZ.setVisibility(0);
                        aVar.iXZ.setTag(facePackageData.tag_url);
                        aVar.iXZ.startLoad(facePackageData.tag_url, 21, false);
                        return;
                    }
                    aVar.iXZ.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            b(aVar);
            switch (aVar.iWR) {
                case 1:
                    aVar.iXX.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    aVar.iXV.setVisibility(0);
                    aVar.iXW.setVisibility(0);
                    return;
                case 5:
                    aVar.iXY.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(a aVar, int i) {
        if (aVar != null) {
            if (aVar.iWR == 5) {
                e(aVar, i);
                return;
            }
            switch (aVar.iWR) {
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
        aVar.iXW.setText(aVar.iYa);
        aVar.iXW.setBackgroundResource(0);
        ap.setBackgroundResource(aVar.iXV, R.drawable.btn_all_white);
    }

    private void c(a aVar, int i) {
        aVar.iXW.setText((CharSequence) null);
        ap.setBackgroundResource(aVar.iXV, R.drawable.btn_all_blue);
        ap.setBackgroundResource(aVar.iXW, R.drawable.icon_content_download);
    }

    private void d(a aVar, int i) {
        aVar.iXW.setText(aVar.iYa);
        aVar.iXW.setBackgroundResource(0);
        ap.setBackgroundResource(aVar.iXV, R.drawable.faceshop_list_btn_selector);
    }

    private void e(a aVar, int i) {
        b(aVar);
        aVar.iXY.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(aVar.mPosition);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.iXN);
            int i3 = i2 < this.iXO ? this.iXO : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.iXd.getLayoutParams();
            layoutParams.width = i3;
            aVar.iXd.setLayoutParams(layoutParams);
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.iXW.setVisibility(8);
            aVar.iXV.setVisibility(8);
            aVar.iXX.setVisibility(8);
            aVar.iXY.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, a aVar) {
        if (facePackageData != null && aVar != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                aVar.iWR = 5;
            } else if (i3 == 1) {
                aVar.iWR = 1;
            } else if (i == 2) {
                aVar.iWR = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    aVar.iWR = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    aVar.iWR = 3;
                } else {
                    aVar.iWR = 4;
                }
            }
        }
    }

    public void yb(int i) {
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.iXQ = new FacePackageDownloadModel(this.iXM.getPageContext().getContext());
            this.iXQ.JX(String.valueOf(facePackageData.pid));
            this.iXQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        facePackageData.pack_url = facePackageDownloadData.pack_url;
                        f.cyE().aG(String.valueOf(facePackageData.pid), facePackageData.pname, facePackageData.pack_url);
                    } else if (facePackageDownloadData.usermsg != null) {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), facePackageDownloadData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    public void yc(int i) {
        TiebaStatic.log("emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public void yd(final int i) {
        TiebaStatic.log("emotion_package_list_buy");
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.iXL != null) {
            this.iXM.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.iWN = new FaceBuyModel(this.iXM.getPageContext().getContext());
            this.iWN.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    s.this.iXM.hideProgressBar();
                    if (obj == null || !(obj instanceof FaceBuyData)) {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status == 2) {
                            UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), R.string.has_buy_book);
                            facePackageData.buy_status = 1;
                            facePackageData.can_download = 1;
                            s.this.notifyDataSetChanged();
                            return;
                        }
                        facePackageData.orderId = faceBuyData.buy_info.order_id;
                        IntentConfig intentConfig = new IntentConfig(s.this.iXM);
                        intentConfig.getIntent().putExtra("tag_url", str);
                        intentConfig.getIntent().putExtra("tag_hook_url", str2);
                        intentConfig.getIntent().putExtra("tag_title", s.this.iXM.getString(R.string.buy_book));
                        intentConfig.getIntent().putExtra("tag_position", i);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                    } else if (faceBuyData.usermsg != null) {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), faceBuyData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iXM.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
            this.iWN.JR(valueOf);
        }
    }

    public void onDestroy() {
        if (this.iWN != null) {
            this.iWN.cancelLoadData();
        }
        if (this.iXQ != null) {
            this.iXQ.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        int iYb;
        int position;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TbImageView fkQ;
        TextView gRj;
        TbImageView iQB;
        int iWR;
        FrameLayout iXV;
        TextView iXW;
        TextView iXX;
        FrameLayout iXY;
        TbImageView iXZ;
        ImageView iXd;
        String iYa;
        int mPosition;
        TextView mTitle;

        private a() {
        }
    }
}
