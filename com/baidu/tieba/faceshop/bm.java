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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class bm extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private final Context c;
    private final int e;
    private final int f;
    private final com.baidu.tbadk.editortool.aa g;
    private final int h;
    private final int i;
    private ar k;
    private x l;
    private int j = -1;
    View.OnClickListener a = new bn(this);

    public final int a() {
        return this.j;
    }

    public bm(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.util.i.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        this.g = new com.baidu.tbadk.editortool.aa(context);
        this.g.a(this.e, this.f);
        this.h = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_content_download_down).getWidth();
        this.i = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.bg_content_download_up).getWidth();
        this.k = null;
        this.l = null;
    }

    public final void a(FaceShopData faceShopData) {
        this.b = faceShopData;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.b == null || this.b.packList == null) {
            return 0;
        }
        return this.b.packList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
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
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return (this.b == null || this.b.packList == null || this.b.packList.get(i) == null) ? 2 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        int itemViewType = getItemViewType(i);
        int l = TbadkApplication.j().l();
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 1) {
                bq bqVar = new bq(this, (byte) 0);
                View inflate = from.inflate(com.baidu.tieba.a.i.face_shop_list_tem, (ViewGroup) null);
                bqVar.b = (TextView) inflate.findViewById(com.baidu.tieba.a.h.title);
                bqVar.a = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.image);
                bqVar.a.setDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d);
                bqVar.a.setNightDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                bqVar.c = (FrameLayout) inflate.findViewById(com.baidu.tieba.a.h.btn);
                bqVar.d = (TextView) inflate.findViewById(com.baidu.tieba.a.h.btn_text);
                bqVar.e = (TextView) inflate.findViewById(com.baidu.tieba.a.h.downloaded);
                bqVar.g = (FrameLayout) inflate.findViewById(com.baidu.tieba.a.h.downloading);
                bqVar.f = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.downloading_up);
                bqVar.h = (TextView) inflate.findViewById(com.baidu.tieba.a.h.intro);
                bqVar.i = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.icon);
                bqVar.i.setDefaultResource(0);
                bqVar.i.setNightDefaultResource(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
                layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_img_marginBottom));
                bqVar.a.setLayoutParams(layoutParams);
                bqVar.d.setClickable(false);
                bqVar.c.setClickable(true);
                bqVar.c.setOnClickListener(this.a);
                bqVar.j = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.title_tag);
                inflate.setTag(bqVar);
                view2 = inflate;
            } else {
                view2 = null;
            }
            view = view2;
        }
        bq bqVar2 = (bq) view.getTag();
        if (this.c instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.c).getLayoutMode().a(l == 1);
            ((com.baidu.tbadk.a) this.c).getLayoutMode().a(view);
        }
        if (this.b != null && bqVar2 != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bqVar2.m = i;
                    bqVar2.b.setText(facePackageData.pname);
                    bqVar2.h.setText(facePackageData.pdesc);
                    bqVar2.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon == null || facePackageData.newIcon.length() <= 0) {
                        bqVar2.i.setVisibility(8);
                    } else {
                        bqVar2.i.setTag(facePackageData.newIcon);
                        bqVar2.i.setVisibility(0);
                    }
                    bqVar2.k = facePackageData.price;
                    if (facePackageData != null && bqVar2 != null) {
                        int i2 = facePackageData.buyStatus;
                        int i3 = facePackageData.canDownload;
                        int i4 = facePackageData.downloaded;
                        if (facePackageData.downloading == 1) {
                            bqVar2.l = 5;
                        } else if (i4 == 1) {
                            bqVar2.l = 1;
                        } else if (i2 == 2) {
                            bqVar2.l = 6;
                        } else if (i2 == 1) {
                            if (i3 == 1) {
                                bqVar2.l = 2;
                            }
                        } else if (i2 == 0) {
                            if (i3 == 1) {
                                bqVar2.l = 3;
                            } else {
                                bqVar2.l = 4;
                            }
                        }
                    }
                    br brVar = new br(this, (byte) 0);
                    brVar.b = bqVar2.l;
                    brVar.a = i;
                    bqVar2.c.setTag(brVar);
                    if (TextUtils.isEmpty(facePackageData.tagUrl)) {
                        bqVar2.j.setVisibility(8);
                    } else {
                        bqVar2.j.setVisibility(0);
                        bqVar2.j.setTag(facePackageData.tagUrl);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "fillItemView", e.toString());
            }
        }
        if (bqVar2 != null) {
            a(bqVar2);
            switch (bqVar2.l) {
                case 1:
                    bqVar2.e.setVisibility(0);
                    break;
                case 2:
                case 3:
                case 4:
                    bqVar2.c.setVisibility(0);
                    bqVar2.d.setVisibility(0);
                    break;
                case 5:
                    bqVar2.g.setVisibility(0);
                    break;
            }
        }
        if (bqVar2 != null) {
            if (bqVar2.l != 5) {
                switch (bqVar2.l) {
                    case 2:
                        bqVar2.d.setText((CharSequence) null);
                        if (l != 1) {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_download_selector);
                            bqVar2.d.setBackgroundResource(com.baidu.tieba.a.g.icon_content_download);
                            break;
                        } else {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_download_selector_1);
                            bqVar2.d.setBackgroundResource(com.baidu.tieba.a.g.icon_content_download_1);
                            break;
                        }
                    case 3:
                        bqVar2.d.setText(bqVar2.k);
                        bqVar2.d.setBackgroundResource(0);
                        if (l != 1) {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector);
                            break;
                        } else {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector_1);
                            break;
                        }
                    case 4:
                        bqVar2.d.setText(bqVar2.k);
                        bqVar2.d.setBackgroundResource(0);
                        if (l != 1) {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector);
                            break;
                        } else {
                            bqVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector_1);
                            break;
                        }
                }
            } else {
                a(bqVar2);
                bqVar2.g.setVisibility(0);
                FacePackageData facePackageData2 = (FacePackageData) getItem(bqVar2.m);
                if (facePackageData2 != null) {
                    int i5 = (int) ((((float) facePackageData2.downloadNow) / ((float) facePackageData2.downloadTotal)) * this.h);
                    int i6 = i5 < this.i ? this.i : i5;
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bqVar2.f.getLayoutParams();
                    layoutParams2.width = i6;
                    bqVar2.f.setLayoutParams(layoutParams2);
                }
            }
        }
        return view;
    }

    private static void a(bq bqVar) {
        if (bqVar != null) {
            bqVar.d.setVisibility(8);
            bqVar.c.setVisibility(8);
            bqVar.e.setVisibility(8);
            bqVar.g.setVisibility(8);
        }
    }

    public final void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new ar();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new bo(this, facePackageData));
        }
    }

    public final void b(int i) {
        com.baidu.tbadk.core.g.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public final void c(int i) {
        com.baidu.tbadk.core.g.a(this.c, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.b != null) {
            com.baidu.tbadk.a aVar = (com.baidu.tbadk.a) this.c;
            aVar.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.l = new x();
            this.l.setLoadDataCallBack(new bp(this, aVar, facePackageData, i));
            this.l.a(valueOf);
        }
    }

    public final com.baidu.tbadk.editortool.aa b() {
        return this.g;
    }

    public final void c() {
        if (this.l != null) {
            this.l.cancelLoadData();
        }
        if (this.k != null) {
            this.k.cancelLoadData();
        }
    }
}
