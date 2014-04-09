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
public final class bo extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private final Context c;
    private final int e;
    private final int f;
    private final com.baidu.tbadk.editortool.ab g;
    private final int h;
    private final int i;
    private at k;
    private z l;
    private int j = -1;
    View.OnClickListener a = new bp(this);

    public final int a() {
        return this.j;
    }

    public bo(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.util.i.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        this.g = new com.baidu.tbadk.editortool.ab(context);
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
                bs bsVar = new bs(this, (byte) 0);
                View inflate = from.inflate(com.baidu.tieba.a.i.face_shop_list_tem, (ViewGroup) null);
                bsVar.b = (TextView) inflate.findViewById(com.baidu.tieba.a.h.title);
                bsVar.a = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.image);
                bsVar.a.setDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d);
                bsVar.a.setNightDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                bsVar.c = (FrameLayout) inflate.findViewById(com.baidu.tieba.a.h.btn);
                bsVar.d = (TextView) inflate.findViewById(com.baidu.tieba.a.h.btn_text);
                bsVar.e = (TextView) inflate.findViewById(com.baidu.tieba.a.h.downloaded);
                bsVar.g = (FrameLayout) inflate.findViewById(com.baidu.tieba.a.h.downloading);
                bsVar.f = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.downloading_up);
                bsVar.h = (TextView) inflate.findViewById(com.baidu.tieba.a.h.intro);
                bsVar.i = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.icon);
                bsVar.i.setDefaultResource(0);
                bsVar.i.setNightDefaultResource(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
                layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.faceshop_img_marginBottom));
                bsVar.a.setLayoutParams(layoutParams);
                bsVar.d.setClickable(false);
                bsVar.c.setClickable(true);
                bsVar.c.setOnClickListener(this.a);
                bsVar.j = (TbImageView) inflate.findViewById(com.baidu.tieba.a.h.title_tag);
                inflate.setTag(bsVar);
                view2 = inflate;
            } else {
                view2 = null;
            }
            view = view2;
        }
        bs bsVar2 = (bs) view.getTag();
        if (this.c instanceof com.baidu.tbadk.a) {
            ((com.baidu.tbadk.a) this.c).getLayoutMode().a(l == 1);
            ((com.baidu.tbadk.a) this.c).getLayoutMode().a(view);
        }
        if (this.b != null && bsVar2 != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bsVar2.m = i;
                    bsVar2.b.setText(facePackageData.pname);
                    bsVar2.h.setText(facePackageData.pdesc);
                    bsVar2.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon == null || facePackageData.newIcon.length() <= 0) {
                        bsVar2.i.setVisibility(8);
                    } else {
                        bsVar2.i.setTag(facePackageData.newIcon);
                        bsVar2.i.setVisibility(0);
                    }
                    bsVar2.k = facePackageData.price;
                    if (facePackageData != null && bsVar2 != null) {
                        int i2 = facePackageData.buyStatus;
                        int i3 = facePackageData.canDownload;
                        int i4 = facePackageData.downloaded;
                        if (facePackageData.downloading == 1) {
                            bsVar2.l = 5;
                        } else if (i4 == 1) {
                            bsVar2.l = 1;
                        } else if (i2 == 2) {
                            bsVar2.l = 6;
                        } else if (i2 == 1) {
                            if (i3 == 1) {
                                bsVar2.l = 2;
                            }
                        } else if (i2 == 0) {
                            if (i3 == 1) {
                                bsVar2.l = 3;
                            } else {
                                bsVar2.l = 4;
                            }
                        }
                    }
                    bt btVar = new bt(this, (byte) 0);
                    btVar.b = bsVar2.l;
                    btVar.a = i;
                    bsVar2.c.setTag(btVar);
                    if (TextUtils.isEmpty(facePackageData.tagUrl)) {
                        bsVar2.j.setVisibility(8);
                    } else {
                        bsVar2.j.setVisibility(0);
                        bsVar2.j.setTag(facePackageData.tagUrl);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "fillItemView", e.toString());
            }
        }
        if (bsVar2 != null) {
            a(bsVar2);
            switch (bsVar2.l) {
                case 1:
                    bsVar2.e.setVisibility(0);
                    break;
                case 2:
                case 3:
                case 4:
                    bsVar2.c.setVisibility(0);
                    bsVar2.d.setVisibility(0);
                    break;
                case 5:
                    bsVar2.g.setVisibility(0);
                    break;
            }
        }
        if (bsVar2 != null) {
            if (bsVar2.l != 5) {
                switch (bsVar2.l) {
                    case 2:
                        bsVar2.d.setText((CharSequence) null);
                        if (l != 1) {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_download_selector);
                            bsVar2.d.setBackgroundResource(com.baidu.tieba.a.g.icon_content_download);
                            break;
                        } else {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_download_selector_1);
                            bsVar2.d.setBackgroundResource(com.baidu.tieba.a.g.icon_content_download_1);
                            break;
                        }
                    case 3:
                        bsVar2.d.setText(bsVar2.k);
                        bsVar2.d.setBackgroundResource(0);
                        if (l != 1) {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector);
                            break;
                        } else {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector_1);
                            break;
                        }
                    case 4:
                        bsVar2.d.setText(bsVar2.k);
                        bsVar2.d.setBackgroundResource(0);
                        if (l != 1) {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector);
                            break;
                        } else {
                            bsVar2.c.setBackgroundResource(com.baidu.tieba.a.g.faceshop_list_btn_selector_1);
                            break;
                        }
                }
            } else {
                a(bsVar2);
                bsVar2.g.setVisibility(0);
                FacePackageData facePackageData2 = (FacePackageData) getItem(bsVar2.m);
                if (facePackageData2 != null) {
                    int i5 = (int) ((((float) facePackageData2.downloadNow) / ((float) facePackageData2.downloadTotal)) * this.h);
                    int i6 = i5 < this.i ? this.i : i5;
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) bsVar2.f.getLayoutParams();
                    layoutParams2.width = i6;
                    bsVar2.f.setLayoutParams(layoutParams2);
                }
            }
        }
        return view;
    }

    private static void a(bs bsVar) {
        if (bsVar != null) {
            bsVar.d.setVisibility(8);
            bsVar.c.setVisibility(8);
            bsVar.e.setVisibility(8);
            bsVar.g.setVisibility(8);
        }
    }

    public final void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new at();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new bq(this, facePackageData));
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
            this.l = new z();
            this.l.setLoadDataCallBack(new br(this, aVar, facePackageData, i));
            this.l.a(valueOf);
        }
    }

    public final com.baidu.tbadk.editortool.ab b() {
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
