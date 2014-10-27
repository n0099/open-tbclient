package com.baidu.tieba.faceshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bi extends BaseAdapter {
    private static int ats;
    private x atd;
    private FaceShopData aup;
    private final int auq;
    private final int aur;
    private ap aut;
    private final Context mContext;
    private final int mImageHeight;
    private final int mImageWidth;
    private int aus = -1;
    View.OnClickListener auu = new bj(this);

    public int Dx() {
        return this.aus;
    }

    public bi(Context context) {
        this.mContext = context;
        ats = com.baidu.adp.lib.util.m.n(context);
        this.mImageWidth = ats - (context.getResources().getDimensionPixelSize(bx.faceshop_page_padding) * 2);
        this.mImageHeight = (int) (this.mImageWidth * 0.38495576f);
        Bitmap a = com.baidu.tbadk.core.util.d.a(this.mContext, by.bg_content_download_down);
        if (a != null) {
            this.auq = a.getWidth();
        } else {
            this.auq = 0;
        }
        Bitmap a2 = com.baidu.tbadk.core.util.d.a(this.mContext, by.bg_content_download_up);
        if (a2 != null) {
            this.aur = a2.getWidth();
        } else {
            this.aur = 0;
        }
        this.aut = null;
        this.atd = null;
    }

    public void a(FaceShopData faceShopData) {
        this.aup = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aup == null || this.aup.pack_list == null) {
            return 0;
        }
        return this.aup.pack_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aup == null || this.aup.pack_list == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.aup.pack_list;
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
        return (this.aup == null || this.aup.pack_list == null || this.aup.pack_list.get(i) == null) ? 2 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (view == null) {
            view = a(itemViewType, viewGroup);
        }
        bm bmVar = (bm) view.getTag();
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(skinType == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(view);
        }
        a(i, bmVar);
        a(bmVar);
        a(bmVar, skinType);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        if (i == 1) {
            bm bmVar = new bm(this, null);
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_shop_list_tem, null);
            bmVar.JM = (TextView) inflate.findViewById(bz.title);
            bmVar.atZ = (TbImageView) inflate.findViewById(bz.image);
            bmVar.auz = (FrameLayout) inflate.findViewById(bz.btn);
            bmVar.auA = (TextView) inflate.findViewById(bz.btn_text);
            bmVar.auB = (TextView) inflate.findViewById(bz.downloaded);
            bmVar.auC = (FrameLayout) inflate.findViewById(bz.downloading);
            bmVar.atG = (ImageView) inflate.findViewById(bz.downloading_up);
            bmVar.auD = (TextView) inflate.findViewById(bz.intro);
            bmVar.anF = (TbImageView) inflate.findViewById(bz.icon);
            bmVar.anF.setDefaultResource(0);
            bmVar.anF.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            layoutParams.setMargins(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(bx.faceshop_img_marginBottom));
            bmVar.atZ.setLayoutParams(layoutParams);
            bmVar.auA.setClickable(false);
            bmVar.auz.setClickable(true);
            bmVar.auz.setOnClickListener(this.auu);
            bmVar.auE = (TbImageView) inflate.findViewById(bz.title_tag);
            inflate.setTag(bmVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, bm bmVar) {
        if (this.aup != null && bmVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bmVar.Uy = i;
                    bmVar.JM.setText(facePackageData.pname);
                    bmVar.auD.setText(facePackageData.pdesc);
                    bmVar.atZ.setTag(facePackageData.banner_url);
                    bmVar.atZ.a(facePackageData.banner_url, 10, this.mImageWidth, this.mImageHeight, false);
                    if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                        bmVar.anF.setTag(facePackageData.new_icon);
                        bmVar.anF.c(facePackageData.new_icon, 21, false);
                        bmVar.anF.setVisibility(0);
                    } else {
                        bmVar.anF.setVisibility(8);
                    }
                    bmVar.auF = facePackageData.price;
                    a(facePackageData, bmVar);
                    bn bnVar = new bn(this, null);
                    bnVar.auG = bmVar.atm;
                    bnVar.position = i;
                    bmVar.auz.setTag(bnVar);
                    if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                        bmVar.auE.setVisibility(0);
                        bmVar.auE.setTag(facePackageData.tag_url);
                        bmVar.auE.c(facePackageData.tag_url, 21, false);
                        return;
                    }
                    bmVar.auE.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(bm bmVar) {
        if (bmVar != null) {
            b(bmVar);
            switch (bmVar.atm) {
                case 1:
                    bmVar.auB.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    bmVar.auz.setVisibility(0);
                    bmVar.auA.setVisibility(0);
                    return;
                case 5:
                    bmVar.auC.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bm bmVar, int i) {
        if (bmVar != null) {
            if (bmVar.atm == 5) {
                e(bmVar, i);
                return;
            }
            switch (bmVar.atm) {
                case 2:
                    c(bmVar, i);
                    return;
                case 3:
                    b(bmVar, i);
                    return;
                case 4:
                    d(bmVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(bm bmVar, int i) {
        bmVar.auA.setText(bmVar.auF);
        bmVar.auA.setBackgroundResource(0);
        com.baidu.tbadk.core.util.aw.h(bmVar.auz, by.faceshop_list_btn_selector);
    }

    private void c(bm bmVar, int i) {
        bmVar.auA.setText((CharSequence) null);
        com.baidu.tbadk.core.util.aw.h(bmVar.auz, by.faceshop_list_download_selector);
        com.baidu.tbadk.core.util.aw.h((View) bmVar.auA, by.icon_content_download);
    }

    private void d(bm bmVar, int i) {
        bmVar.auA.setText(bmVar.auF);
        bmVar.auA.setBackgroundResource(0);
        com.baidu.tbadk.core.util.aw.h(bmVar.auz, by.faceshop_list_btn_selector);
    }

    private void e(bm bmVar, int i) {
        b(bmVar);
        bmVar.auC.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(bmVar.Uy);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.auq);
            int i3 = i2 < this.aur ? this.aur : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bmVar.atG.getLayoutParams();
            layoutParams.width = i3;
            bmVar.atG.setLayoutParams(layoutParams);
        }
    }

    private void b(bm bmVar) {
        if (bmVar != null) {
            bmVar.auA.setVisibility(8);
            bmVar.auz.setVisibility(8);
            bmVar.auB.setVisibility(8);
            bmVar.auC.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bm bmVar) {
        if (facePackageData != null && bmVar != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                bmVar.atm = 5;
            } else if (i3 == 1) {
                bmVar.atm = 1;
            } else if (i == 2) {
                bmVar.atm = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    bmVar.atm = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    bmVar.atm = 3;
                } else {
                    bmVar.atm = 4;
                }
            }
        }
    }

    public void ev(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.aut = new ap(this.mContext);
            this.aut.eU(String.valueOf(facePackageData.pid));
            this.aut.setLoadDataCallBack(new bk(this, facePackageData));
        }
    }

    public void ew(int i) {
        com.baidu.tbadk.core.i.l(this.mContext, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public void ex(int i) {
        com.baidu.tbadk.core.i.l(this.mContext, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.aup != null) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.atd = new x(this.mContext);
            this.atd.setLoadDataCallBack(new bl(this, baseActivity, facePackageData, i));
            this.atd.eO(valueOf);
        }
    }

    public void onDestroy() {
        if (this.atd != null) {
            this.atd.cancelLoadData();
        }
        if (this.aut != null) {
            this.aut.cancelLoadData();
        }
    }
}
