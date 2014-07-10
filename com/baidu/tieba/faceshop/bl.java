package com.baidu.tieba.faceshop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
public class bl extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private final Context c;
    private final int e;
    private final int f;
    private final com.baidu.tbadk.editortool.aa g;
    private final int h;
    private final int i;
    private ar k;
    private z l;
    private int j = -1;
    View.OnClickListener a = new bm(this);

    public int a() {
        return this.j;
    }

    public bl(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.util.j.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(com.baidu.tieba.t.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        this.g = new com.baidu.tbadk.editortool.aa(context);
        this.g.a(this.e, this.f);
        this.h = com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.bg_content_download_down).getWidth();
        this.i = com.baidu.tbadk.core.util.h.a(com.baidu.tieba.u.bg_content_download_up).getWidth();
        this.k = null;
        this.l = null;
    }

    public void a(FaceShopData faceShopData) {
        this.b = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b == null || this.b.packList == null) {
            return 0;
        }
        return this.b.packList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.b == null || this.b.packList == null) {
            return null;
        }
        ArrayList<FacePackageData> arrayList = this.b.packList;
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
        return (this.b == null || this.b.packList == null || this.b.packList.get(i) == null) ? 2 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        int skinType = TbadkApplication.m252getInst().getSkinType();
        if (view == null) {
            view = a(itemViewType, viewGroup);
        }
        bp bpVar = (bp) view.getTag();
        if (this.c instanceof BaseActivity) {
            ((BaseActivity) this.c).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.c).getLayoutMode().a(view);
        }
        a(i, bpVar);
        a(bpVar);
        a(bpVar, skinType);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.c);
        if (i == 1) {
            bp bpVar = new bp(this, null);
            View inflate = from.inflate(com.baidu.tieba.w.face_shop_list_tem, (ViewGroup) null);
            bpVar.b = (TextView) inflate.findViewById(com.baidu.tieba.v.title);
            bpVar.a = (TbImageView) inflate.findViewById(com.baidu.tieba.v.image);
            bpVar.a.setDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d);
            bpVar.a.setNightDefaultResource(com.baidu.tieba.u.pic_baidu_logo_d_1);
            bpVar.c = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.btn);
            bpVar.d = (TextView) inflate.findViewById(com.baidu.tieba.v.btn_text);
            bpVar.e = (TextView) inflate.findViewById(com.baidu.tieba.v.downloaded);
            bpVar.g = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.downloading);
            bpVar.f = (ImageView) inflate.findViewById(com.baidu.tieba.v.downloading_up);
            bpVar.h = (TextView) inflate.findViewById(com.baidu.tieba.v.intro);
            bpVar.i = (TbImageView) inflate.findViewById(com.baidu.tieba.v.icon);
            bpVar.i.setDefaultResource(0);
            bpVar.i.setNightDefaultResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
            layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.faceshop_img_marginBottom));
            bpVar.a.setLayoutParams(layoutParams);
            bpVar.d.setClickable(false);
            bpVar.c.setClickable(true);
            bpVar.c.setOnClickListener(this.a);
            bpVar.j = (TbImageView) inflate.findViewById(com.baidu.tieba.v.title_tag);
            inflate.setTag(bpVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, bp bpVar) {
        if (this.b != null && bpVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bpVar.m = i;
                    bpVar.b.setText(facePackageData.pname);
                    bpVar.h.setText(facePackageData.pdesc);
                    bpVar.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon != null && facePackageData.newIcon.length() > 0) {
                        bpVar.i.setTag(facePackageData.newIcon);
                        bpVar.i.setVisibility(0);
                    } else {
                        bpVar.i.setVisibility(8);
                    }
                    bpVar.k = facePackageData.price;
                    a(facePackageData, bpVar);
                    bq bqVar = new bq(this, null);
                    bqVar.b = bpVar.l;
                    bqVar.a = i;
                    bpVar.c.setTag(bqVar);
                    if (!TextUtils.isEmpty(facePackageData.tagUrl)) {
                        bpVar.j.setVisibility(0);
                        bpVar.j.setTag(facePackageData.tagUrl);
                        return;
                    }
                    bpVar.j.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(bp bpVar) {
        if (bpVar != null) {
            b(bpVar);
            switch (bpVar.l) {
                case 1:
                    bpVar.e.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    bpVar.c.setVisibility(0);
                    bpVar.d.setVisibility(0);
                    return;
                case 5:
                    bpVar.g.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bp bpVar, int i) {
        if (bpVar != null) {
            if (bpVar.l == 5) {
                e(bpVar, i);
                return;
            }
            switch (bpVar.l) {
                case 2:
                    c(bpVar, i);
                    return;
                case 3:
                    b(bpVar, i);
                    return;
                case 4:
                    d(bpVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(bp bpVar, int i) {
        bpVar.d.setText(bpVar.k);
        bpVar.d.setBackgroundResource(0);
        if (i == 1) {
            bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector_1);
        } else {
            bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector);
        }
    }

    private void c(bp bpVar, int i) {
        bpVar.d.setText((CharSequence) null);
        if (i == 1) {
            bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_download_selector_1);
            bpVar.d.setBackgroundResource(com.baidu.tieba.u.icon_content_download_1);
            return;
        }
        bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_download_selector);
        bpVar.d.setBackgroundResource(com.baidu.tieba.u.icon_content_download);
    }

    private void d(bp bpVar, int i) {
        bpVar.d.setText(bpVar.k);
        bpVar.d.setBackgroundResource(0);
        if (i == 1) {
            bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector_1);
        } else {
            bpVar.c.setBackgroundResource(com.baidu.tieba.u.faceshop_list_btn_selector);
        }
    }

    private void e(bp bpVar, int i) {
        b(bpVar);
        bpVar.g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(bpVar.m);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.h);
            int i3 = i2 < this.i ? this.i : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bpVar.f.getLayoutParams();
            layoutParams.width = i3;
            bpVar.f.setLayoutParams(layoutParams);
        }
    }

    private void b(bp bpVar) {
        if (bpVar != null) {
            bpVar.d.setVisibility(8);
            bpVar.c.setVisibility(8);
            bpVar.e.setVisibility(8);
            bpVar.g.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bp bpVar) {
        if (facePackageData != null && bpVar != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                bpVar.l = 5;
            } else if (i3 == 1) {
                bpVar.l = 1;
            } else if (i == 2) {
                bpVar.l = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    bpVar.l = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    bpVar.l = 3;
                } else {
                    bpVar.l = 4;
                }
            }
        }
    }

    public void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new ar();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new bn(this, facePackageData));
        }
    }

    public void b(int i) {
        com.baidu.tbadk.core.f.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        com.baidu.tbadk.core.f.a(this.c, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.b != null) {
            BaseActivity baseActivity = (BaseActivity) this.c;
            baseActivity.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.l = new z();
            this.l.setLoadDataCallBack(new bo(this, baseActivity, facePackageData, i));
            this.l.a(valueOf);
        }
    }

    public com.baidu.tbadk.editortool.aa b() {
        return this.g;
    }

    public void c() {
        if (this.l != null) {
            this.l.cancelLoadData();
        }
        if (this.k != null) {
            this.k.cancelLoadData();
        }
    }
}
