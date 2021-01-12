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
/* loaded from: classes8.dex */
public class s extends BaseAdapter {
    private static int mScreenWidth;
    private FaceBuyModel iPj;
    private FaceShopData iQh;
    private final r iQi;
    private final int iQj;
    private final int iQk;
    private FacePackageDownloadModel iQm;
    private final int mImageHeight;
    private final int mImageWidth;
    private int iQl = -1;
    View.OnClickListener iQn = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.s.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                b bVar = (b) view.getTag();
                if (bVar != null) {
                    int i = bVar.position;
                    if (!TbadkApplication.isLogin()) {
                        s.this.iQl = bVar.position;
                        TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(s.this.iQi.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_USE)));
                    } else {
                        switch (bVar.iQx) {
                            case 2:
                                s.this.xQ(i);
                                break;
                            case 3:
                                s.this.xR(i);
                                break;
                            case 4:
                                s.this.xS(i);
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public int cyc() {
        return this.iQl;
    }

    public s(r rVar) {
        this.iQi = rVar;
        mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(rVar.getPageContext().getPageActivity());
        this.mImageWidth = mScreenWidth - (rVar.getResources().getDimensionPixelSize(R.dimen.ds22) * 2);
        this.mImageHeight = (int) (this.mImageWidth * 0.38495576f);
        Bitmap resBitmap = BitmapHelper.getResBitmap(this.iQi.getPageContext().getContext(), R.drawable.bg_content_download_down);
        if (resBitmap != null) {
            this.iQj = resBitmap.getWidth();
        } else {
            this.iQj = 0;
        }
        Bitmap resBitmap2 = BitmapHelper.getResBitmap(this.iQi.getPageContext().getContext(), R.drawable.bg_content_download_up);
        if (resBitmap2 != null) {
            this.iQk = resBitmap2.getWidth();
        } else {
            this.iQk = 0;
        }
        this.iQm = null;
        this.iPj = null;
    }

    public void a(FaceShopData faceShopData) {
        this.iQh = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iQh == null || this.iQh.pack_list == null) {
            return 0;
        }
        return this.iQh.pack_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iQh == null || this.iQh.pack_list == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.iQh.pack_list;
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
        return (this.iQh == null || this.iQh.pack_list == null || this.iQh.pack_list.get(i) == null) ? 2 : 1;
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
        com.baidu.tbadk.core.c layoutMode = this.iQi.getLayoutMode();
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
            View inflate = LayoutInflater.from(this.iQi.getPageContext().getPageActivity()).inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            aVar.mTitle = (TextView) inflate.findViewById(R.id.title);
            aVar.iIW = (TbImageView) inflate.findViewById(R.id.image);
            aVar.iQr = (FrameLayout) inflate.findViewById(R.id.btn);
            aVar.iQs = (TextView) inflate.findViewById(R.id.btn_text);
            aVar.iQt = (TextView) inflate.findViewById(R.id.downloaded);
            aVar.iQu = (FrameLayout) inflate.findViewById(R.id.downloading);
            aVar.iPz = (ImageView) inflate.findViewById(R.id.downloading_up);
            aVar.gMG = (TextView) inflate.findViewById(R.id.intro);
            aVar.fgY = (TbImageView) inflate.findViewById(R.id.icon);
            aVar.fgY.setDefaultResource(0);
            aVar.fgY.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            layoutParams.setMargins(0, 0, 0, this.iQi.getResources().getDimensionPixelSize(R.dimen.ds8));
            aVar.iIW.setLayoutParams(layoutParams);
            aVar.iQs.setClickable(false);
            aVar.iQr.setClickable(true);
            aVar.iQr.setOnClickListener(this.iQn);
            aVar.iQv = (TbImageView) inflate.findViewById(R.id.title_tag);
            inflate.setTag(aVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, a aVar) {
        if (this.iQh != null && aVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    aVar.mPosition = i;
                    aVar.mTitle.setText(facePackageData.pname);
                    aVar.gMG.setText(facePackageData.pdesc);
                    aVar.iIW.setTag(facePackageData.banner_url);
                    aVar.iIW.a(facePackageData.banner_url, 10, this.mImageWidth, this.mImageHeight, false);
                    if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                        aVar.fgY.setTag(facePackageData.new_icon);
                        aVar.fgY.startLoad(facePackageData.new_icon, 21, false);
                        aVar.fgY.setVisibility(0);
                    } else {
                        aVar.fgY.setVisibility(8);
                    }
                    aVar.iQw = facePackageData.price;
                    a(facePackageData, aVar);
                    b bVar = new b();
                    bVar.iQx = aVar.iPn;
                    bVar.position = i;
                    aVar.iQr.setTag(bVar);
                    if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                        aVar.iQv.setVisibility(0);
                        aVar.iQv.setTag(facePackageData.tag_url);
                        aVar.iQv.startLoad(facePackageData.tag_url, 21, false);
                        return;
                    }
                    aVar.iQv.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            b(aVar);
            switch (aVar.iPn) {
                case 1:
                    aVar.iQt.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    aVar.iQr.setVisibility(0);
                    aVar.iQs.setVisibility(0);
                    return;
                case 5:
                    aVar.iQu.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(a aVar, int i) {
        if (aVar != null) {
            if (aVar.iPn == 5) {
                e(aVar, i);
                return;
            }
            switch (aVar.iPn) {
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
        aVar.iQs.setText(aVar.iQw);
        aVar.iQs.setBackgroundResource(0);
        ao.setBackgroundResource(aVar.iQr, R.drawable.btn_all_white);
    }

    private void c(a aVar, int i) {
        aVar.iQs.setText((CharSequence) null);
        ao.setBackgroundResource(aVar.iQr, R.drawable.btn_all_blue);
        ao.setBackgroundResource(aVar.iQs, R.drawable.icon_content_download);
    }

    private void d(a aVar, int i) {
        aVar.iQs.setText(aVar.iQw);
        aVar.iQs.setBackgroundResource(0);
        ao.setBackgroundResource(aVar.iQr, R.drawable.faceshop_list_btn_selector);
    }

    private void e(a aVar, int i) {
        b(aVar);
        aVar.iQu.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(aVar.mPosition);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.iQj);
            int i3 = i2 < this.iQk ? this.iQk : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.iPz.getLayoutParams();
            layoutParams.width = i3;
            aVar.iPz.setLayoutParams(layoutParams);
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.iQs.setVisibility(8);
            aVar.iQr.setVisibility(8);
            aVar.iQt.setVisibility(8);
            aVar.iQu.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, a aVar) {
        if (facePackageData != null && aVar != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                aVar.iPn = 5;
            } else if (i3 == 1) {
                aVar.iPn = 1;
            } else if (i == 2) {
                aVar.iPn = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    aVar.iPn = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    aVar.iPn = 3;
                } else {
                    aVar.iPn = 4;
                }
            }
        }
    }

    public void xQ(int i) {
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.iQm = new FacePackageDownloadModel(this.iQi.getPageContext().getContext());
            this.iQm.Jc(String.valueOf(facePackageData.pid));
            this.iQm.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    if (obj == null || !(obj instanceof FacePackageDownloadData)) {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FacePackageDownloadData facePackageDownloadData = (FacePackageDownloadData) obj;
                    if (facePackageDownloadData.errno == 0 && facePackageDownloadData.usermsg != null) {
                        facePackageData.pack_url = facePackageDownloadData.pack_url;
                        f.cxg().aF(String.valueOf(facePackageData.pid), facePackageData.pname, facePackageData.pack_url);
                    } else if (facePackageDownloadData.usermsg != null) {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), facePackageDownloadData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
        }
    }

    public void xR(int i) {
        TiebaStatic.log("emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public void xS(final int i) {
        TiebaStatic.log("emotion_package_list_buy");
        final FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.iQh != null) {
            this.iQi.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.iPj = new FaceBuyModel(this.iQi.getPageContext().getContext());
            this.iPj.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.s.3
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    s.this.iQi.hideProgressBar();
                    if (obj == null || !(obj instanceof FaceBuyData)) {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), R.string.neterror);
                        return;
                    }
                    FaceBuyData faceBuyData = (FaceBuyData) obj;
                    if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                        String str = faceBuyData.buy_info.buy_url;
                        String str2 = faceBuyData.buy_info.return_url;
                        if (faceBuyData.buy_info.buy_status == 2) {
                            UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), R.string.has_buy_book);
                            facePackageData.buy_status = 1;
                            facePackageData.can_download = 1;
                            s.this.notifyDataSetChanged();
                            return;
                        }
                        facePackageData.orderId = faceBuyData.buy_info.order_id;
                        IntentConfig intentConfig = new IntentConfig(s.this.iQi);
                        intentConfig.getIntent().putExtra("tag_url", str);
                        intentConfig.getIntent().putExtra("tag_hook_url", str2);
                        intentConfig.getIntent().putExtra("tag_title", s.this.iQi.getString(R.string.buy_book));
                        intentConfig.getIntent().putExtra("tag_position", i);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_FACEBUYWEBVIEW, intentConfig));
                    } else if (faceBuyData.usermsg != null) {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), faceBuyData.usermsg);
                    } else {
                        UtilHelper.showToast(s.this.iQi.getPageContext().getContext(), R.string.neterror);
                    }
                }
            });
            this.iPj.IW(valueOf);
        }
    }

    public void onDestroy() {
        if (this.iPj != null) {
            this.iPj.cancelLoadData();
        }
        if (this.iQm != null) {
            this.iQm.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b {
        int iQx;
        int position;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        TbImageView fgY;
        TextView gMG;
        TbImageView iIW;
        int iPn;
        ImageView iPz;
        FrameLayout iQr;
        TextView iQs;
        TextView iQt;
        FrameLayout iQu;
        TbImageView iQv;
        String iQw;
        int mPosition;
        TextView mTitle;

        private a() {
        }
    }
}
