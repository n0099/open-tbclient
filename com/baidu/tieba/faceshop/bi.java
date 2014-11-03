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
    private static int atB;
    private x atm;
    private final int auA;
    private ap auC;
    private FaceShopData auy;
    private final int auz;
    private final Context mContext;
    private final int mImageHeight;
    private final int mImageWidth;
    private int auB = -1;
    View.OnClickListener auD = new bj(this);

    public int Dz() {
        return this.auB;
    }

    public bi(Context context) {
        this.mContext = context;
        atB = com.baidu.adp.lib.util.m.n(context);
        this.mImageWidth = atB - (context.getResources().getDimensionPixelSize(bx.faceshop_page_padding) * 2);
        this.mImageHeight = (int) (this.mImageWidth * 0.38495576f);
        Bitmap a = com.baidu.tbadk.core.util.d.a(this.mContext, by.bg_content_download_down);
        if (a != null) {
            this.auz = a.getWidth();
        } else {
            this.auz = 0;
        }
        Bitmap a2 = com.baidu.tbadk.core.util.d.a(this.mContext, by.bg_content_download_up);
        if (a2 != null) {
            this.auA = a2.getWidth();
        } else {
            this.auA = 0;
        }
        this.auC = null;
        this.atm = null;
    }

    public void a(FaceShopData faceShopData) {
        this.auy = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auy == null || this.auy.pack_list == null) {
            return 0;
        }
        return this.auy.pack_list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auy == null || this.auy.pack_list == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.auy.pack_list;
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
        return (this.auy == null || this.auy.pack_list == null || this.auy.pack_list.get(i) == null) ? 2 : 1;
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
            bmVar.JN = (TextView) inflate.findViewById(bz.title);
            bmVar.aui = (TbImageView) inflate.findViewById(bz.image);
            bmVar.auI = (FrameLayout) inflate.findViewById(bz.btn);
            bmVar.auJ = (TextView) inflate.findViewById(bz.btn_text);
            bmVar.auK = (TextView) inflate.findViewById(bz.downloaded);
            bmVar.auL = (FrameLayout) inflate.findViewById(bz.downloading);
            bmVar.atP = (ImageView) inflate.findViewById(bz.downloading_up);
            bmVar.auM = (TextView) inflate.findViewById(bz.intro);
            bmVar.anO = (TbImageView) inflate.findViewById(bz.icon);
            bmVar.anO.setDefaultResource(0);
            bmVar.anO.setDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
            layoutParams.setMargins(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(bx.faceshop_img_marginBottom));
            bmVar.aui.setLayoutParams(layoutParams);
            bmVar.auJ.setClickable(false);
            bmVar.auI.setClickable(true);
            bmVar.auI.setOnClickListener(this.auD);
            bmVar.auN = (TbImageView) inflate.findViewById(bz.title_tag);
            inflate.setTag(bmVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, bm bmVar) {
        if (this.auy != null && bmVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bmVar.UC = i;
                    bmVar.JN.setText(facePackageData.pname);
                    bmVar.auM.setText(facePackageData.pdesc);
                    bmVar.aui.setTag(facePackageData.banner_url);
                    bmVar.aui.a(facePackageData.banner_url, 10, this.mImageWidth, this.mImageHeight, false);
                    if (facePackageData.new_icon != null && facePackageData.new_icon.length() > 0) {
                        bmVar.anO.setTag(facePackageData.new_icon);
                        bmVar.anO.c(facePackageData.new_icon, 21, false);
                        bmVar.anO.setVisibility(0);
                    } else {
                        bmVar.anO.setVisibility(8);
                    }
                    bmVar.auO = facePackageData.price;
                    a(facePackageData, bmVar);
                    bn bnVar = new bn(this, null);
                    bnVar.auP = bmVar.atv;
                    bnVar.position = i;
                    bmVar.auI.setTag(bnVar);
                    if (!TextUtils.isEmpty(facePackageData.tag_url)) {
                        bmVar.auN.setVisibility(0);
                        bmVar.auN.setTag(facePackageData.tag_url);
                        bmVar.auN.c(facePackageData.tag_url, 21, false);
                        return;
                    }
                    bmVar.auN.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(bm bmVar) {
        if (bmVar != null) {
            b(bmVar);
            switch (bmVar.atv) {
                case 1:
                    bmVar.auK.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    bmVar.auI.setVisibility(0);
                    bmVar.auJ.setVisibility(0);
                    return;
                case 5:
                    bmVar.auL.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bm bmVar, int i) {
        if (bmVar != null) {
            if (bmVar.atv == 5) {
                e(bmVar, i);
                return;
            }
            switch (bmVar.atv) {
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
        bmVar.auJ.setText(bmVar.auO);
        bmVar.auJ.setBackgroundResource(0);
        com.baidu.tbadk.core.util.aw.h(bmVar.auI, by.faceshop_list_btn_selector);
    }

    private void c(bm bmVar, int i) {
        bmVar.auJ.setText((CharSequence) null);
        com.baidu.tbadk.core.util.aw.h(bmVar.auI, by.faceshop_list_download_selector);
        com.baidu.tbadk.core.util.aw.h((View) bmVar.auJ, by.icon_content_download);
    }

    private void d(bm bmVar, int i) {
        bmVar.auJ.setText(bmVar.auO);
        bmVar.auJ.setBackgroundResource(0);
        com.baidu.tbadk.core.util.aw.h(bmVar.auI, by.faceshop_list_btn_selector);
    }

    private void e(bm bmVar, int i) {
        b(bmVar);
        bmVar.auL.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(bmVar.UC);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.auz);
            int i3 = i2 < this.auA ? this.auA : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bmVar.atP.getLayoutParams();
            layoutParams.width = i3;
            bmVar.atP.setLayoutParams(layoutParams);
        }
    }

    private void b(bm bmVar) {
        if (bmVar != null) {
            bmVar.auJ.setVisibility(8);
            bmVar.auI.setVisibility(8);
            bmVar.auK.setVisibility(8);
            bmVar.auL.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bm bmVar) {
        if (facePackageData != null && bmVar != null) {
            int i = facePackageData.buy_status;
            int i2 = facePackageData.can_download;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                bmVar.atv = 5;
            } else if (i3 == 1) {
                bmVar.atv = 1;
            } else if (i == 2) {
                bmVar.atv = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    bmVar.atv = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    bmVar.atv = 3;
                } else {
                    bmVar.atv = 4;
                }
            }
        }
    }

    public void ev(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.auC = new ap(this.mContext);
            this.auC.eU(String.valueOf(facePackageData.pid));
            this.auC.setLoadDataCallBack(new bk(this, facePackageData));
        }
    }

    public void ew(int i) {
        com.baidu.tbadk.core.j.l(this.mContext, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buy_status = 1;
            notifyDataSetChanged();
        }
    }

    public void ex(int i) {
        com.baidu.tbadk.core.j.l(this.mContext, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.auy != null) {
            BaseActivity baseActivity = (BaseActivity) this.mContext;
            baseActivity.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.atm = new x(this.mContext);
            this.atm.setLoadDataCallBack(new bl(this, baseActivity, facePackageData, i));
            this.atm.eO(valueOf);
        }
    }

    public void onDestroy() {
        if (this.atm != null) {
            this.atm.cancelLoadData();
        }
        if (this.auC != null) {
            this.auC.cancelLoadData();
        }
    }
}
