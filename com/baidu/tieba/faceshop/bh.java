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
public class bh extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private final Context c;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private ap j;
    private x k;
    private int i = -1;
    View.OnClickListener a = new bi(this);

    public int a() {
        return this.i;
    }

    public bh(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.util.j.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        Bitmap b = com.baidu.tbadk.core.util.d.b(this.c, com.baidu.tieba.t.bg_content_download_down);
        if (b != null) {
            this.g = b.getWidth();
        } else {
            this.g = 0;
        }
        Bitmap b2 = com.baidu.tbadk.core.util.d.b(this.c, com.baidu.tieba.t.bg_content_download_up);
        if (b2 != null) {
            this.h = b2.getWidth();
        } else {
            this.h = 0;
        }
        this.j = null;
        this.k = null;
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
        bl blVar = (bl) view.getTag();
        if (this.c instanceof BaseActivity) {
            ((BaseActivity) this.c).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.c).getLayoutMode().a(view);
        }
        a(i, blVar);
        a(blVar);
        a(blVar, skinType);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        if (i == 1) {
            bl blVar = new bl(this, null);
            View a = com.baidu.adp.lib.e.b.a().a(this.c, com.baidu.tieba.v.face_shop_list_tem, null);
            blVar.b = (TextView) a.findViewById(com.baidu.tieba.u.title);
            blVar.a = (TbImageView) a.findViewById(com.baidu.tieba.u.image);
            blVar.c = (FrameLayout) a.findViewById(com.baidu.tieba.u.btn);
            blVar.d = (TextView) a.findViewById(com.baidu.tieba.u.btn_text);
            blVar.e = (TextView) a.findViewById(com.baidu.tieba.u.downloaded);
            blVar.g = (FrameLayout) a.findViewById(com.baidu.tieba.u.downloading);
            blVar.f = (ImageView) a.findViewById(com.baidu.tieba.u.downloading_up);
            blVar.h = (TextView) a.findViewById(com.baidu.tieba.u.intro);
            blVar.i = (TbImageView) a.findViewById(com.baidu.tieba.u.icon);
            blVar.i.setDefaultResource(0);
            blVar.i.setNightDefaultResource(0);
            blVar.i.setDefaultBgResource(0);
            blVar.i.setNightDefaultBgResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
            layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.s.faceshop_img_marginBottom));
            blVar.a.setLayoutParams(layoutParams);
            blVar.d.setClickable(false);
            blVar.c.setClickable(true);
            blVar.c.setOnClickListener(this.a);
            blVar.j = (TbImageView) a.findViewById(com.baidu.tieba.u.title_tag);
            a.setTag(blVar);
            return a;
        }
        return null;
    }

    private void a(int i, bl blVar) {
        if (this.b != null && blVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    blVar.m = i;
                    blVar.b.setText(facePackageData.pname);
                    blVar.h.setText(facePackageData.pdesc);
                    blVar.a.setTag(facePackageData.bannerUrl);
                    blVar.a.a(facePackageData.bannerUrl, 10, this.e, this.f, false);
                    if (facePackageData.newIcon != null && facePackageData.newIcon.length() > 0) {
                        blVar.i.setTag(facePackageData.newIcon);
                        blVar.i.a(facePackageData.newIcon, 21, false);
                        blVar.i.setVisibility(0);
                    } else {
                        blVar.i.setVisibility(8);
                    }
                    blVar.k = facePackageData.price;
                    a(facePackageData, blVar);
                    bm bmVar = new bm(this, null);
                    bmVar.b = blVar.l;
                    bmVar.a = i;
                    blVar.c.setTag(bmVar);
                    if (!TextUtils.isEmpty(facePackageData.tagUrl)) {
                        blVar.j.setVisibility(0);
                        blVar.j.setTag(facePackageData.tagUrl);
                        blVar.j.a(facePackageData.tagUrl, 21, false);
                        return;
                    }
                    blVar.j.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void a(bl blVar) {
        if (blVar != null) {
            b(blVar);
            switch (blVar.l) {
                case 1:
                    blVar.e.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    blVar.c.setVisibility(0);
                    blVar.d.setVisibility(0);
                    return;
                case 5:
                    blVar.g.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bl blVar, int i) {
        if (blVar != null) {
            if (blVar.l == 5) {
                e(blVar, i);
                return;
            }
            switch (blVar.l) {
                case 2:
                    c(blVar, i);
                    return;
                case 3:
                    b(blVar, i);
                    return;
                case 4:
                    d(blVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(bl blVar, int i) {
        blVar.d.setText(blVar.k);
        blVar.d.setBackgroundResource(0);
        if (i == 1) {
            blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_btn_selector_1);
        } else {
            blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_btn_selector);
        }
    }

    private void c(bl blVar, int i) {
        blVar.d.setText((CharSequence) null);
        if (i == 1) {
            blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_download_selector_1);
            blVar.d.setBackgroundResource(com.baidu.tieba.t.icon_content_download_1);
            return;
        }
        blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_download_selector);
        blVar.d.setBackgroundResource(com.baidu.tieba.t.icon_content_download);
    }

    private void d(bl blVar, int i) {
        blVar.d.setText(blVar.k);
        blVar.d.setBackgroundResource(0);
        if (i == 1) {
            blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_btn_selector_1);
        } else {
            blVar.c.setBackgroundResource(com.baidu.tieba.t.faceshop_list_btn_selector);
        }
    }

    private void e(bl blVar, int i) {
        b(blVar);
        blVar.g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(blVar.m);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.g);
            int i3 = i2 < this.h ? this.h : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) blVar.f.getLayoutParams();
            layoutParams.width = i3;
            blVar.f.setLayoutParams(layoutParams);
        }
    }

    private void b(bl blVar) {
        if (blVar != null) {
            blVar.d.setVisibility(8);
            blVar.c.setVisibility(8);
            blVar.e.setVisibility(8);
            blVar.g.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bl blVar) {
        if (facePackageData != null && blVar != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                blVar.l = 5;
            } else if (i3 == 1) {
                blVar.l = 1;
            } else if (i == 2) {
                blVar.l = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    blVar.l = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    blVar.l = 3;
                } else {
                    blVar.l = 4;
                }
            }
        }
    }

    public void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.j = new ap(this.c);
            this.j.a(String.valueOf(facePackageData.pid));
            this.j.setLoadDataCallBack(new bj(this, facePackageData));
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
            this.k = new x(this.c);
            this.k.setLoadDataCallBack(new bk(this, baseActivity, facePackageData, i));
            this.k.a(valueOf);
        }
    }

    public void b() {
        if (this.k != null) {
            this.k.cancelLoadData();
        }
        if (this.j != null) {
            this.j.cancelLoadData();
        }
    }
}
