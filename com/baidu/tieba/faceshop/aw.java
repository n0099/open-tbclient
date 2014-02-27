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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class aw extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private Context c;
    private int e;
    private int f;
    private com.baidu.tieba.util.i g;
    private int h;
    private int i;
    private ac k;
    private j l;
    private int j = -1;
    View.OnClickListener a = new ax(this);

    public final int a() {
        return this.j;
    }

    public aw(Context context) {
        this.c = context;
        d = BdUtilHelper.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(R.dimen.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        this.g = new com.baidu.tieba.util.i(context);
        this.g.a(this.e, this.f);
        this.h = com.baidu.tieba.util.n.a((int) R.drawable.bg_content_download_down).getWidth();
        this.i = com.baidu.tieba.util.n.a((int) R.drawable.bg_content_download_up).getWidth();
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
        int ae = TiebaApplication.g().ae();
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.c);
            if (itemViewType == 1) {
                ba baVar = new ba(this, (byte) 0);
                View inflate = from.inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
                baVar.b = (TextView) inflate.findViewById(R.id.title);
                baVar.a = (TbImageView) inflate.findViewById(R.id.image);
                baVar.a.setDefaultResource(R.drawable.pic_baidu_logo_d);
                baVar.a.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
                baVar.c = (FrameLayout) inflate.findViewById(R.id.btn);
                baVar.d = (TextView) inflate.findViewById(R.id.btn_text);
                baVar.e = (TextView) inflate.findViewById(R.id.downloaded);
                baVar.g = (FrameLayout) inflate.findViewById(R.id.downloading);
                baVar.f = (ImageView) inflate.findViewById(R.id.downloading_up);
                baVar.h = (TextView) inflate.findViewById(R.id.intro);
                baVar.i = (TbImageView) inflate.findViewById(R.id.icon);
                baVar.i.setDefaultResource(0);
                baVar.i.setNightDefaultResource(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
                layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(R.dimen.faceshop_img_marginBottom));
                baVar.a.setLayoutParams(layoutParams);
                baVar.d.setClickable(false);
                baVar.c.setClickable(true);
                baVar.c.setOnClickListener(this.a);
                baVar.j = (TbImageView) inflate.findViewById(R.id.title_tag);
                inflate.setTag(baVar);
                view2 = inflate;
            } else {
                view2 = null;
            }
            view = view2;
        }
        ba baVar2 = (ba) view.getTag();
        if (this.c instanceof com.baidu.tieba.f) {
            ((com.baidu.tieba.f) this.c).getLayoutMode().a(ae == 1);
            ((com.baidu.tieba.f) this.c).getLayoutMode().a(view);
        }
        if (this.b != null && baVar2 != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    baVar2.m = i;
                    baVar2.b.setText(facePackageData.pname);
                    baVar2.h.setText(facePackageData.pdesc);
                    baVar2.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon == null || facePackageData.newIcon.length() <= 0) {
                        baVar2.i.setVisibility(8);
                    } else {
                        baVar2.i.setTag(facePackageData.newIcon);
                        baVar2.i.setVisibility(0);
                    }
                    baVar2.k = facePackageData.price;
                    if (facePackageData != null && baVar2 != null) {
                        int i2 = facePackageData.buyStatus;
                        int i3 = facePackageData.canDownload;
                        int i4 = facePackageData.downloaded;
                        if (facePackageData.downloading == 1) {
                            baVar2.l = 5;
                        } else if (i4 == 1) {
                            baVar2.l = 1;
                        } else if (i2 == 2) {
                            baVar2.l = 6;
                        } else if (i2 == 1) {
                            if (i3 == 1) {
                                baVar2.l = 2;
                            }
                        } else if (i2 == 0) {
                            if (i3 == 1) {
                                baVar2.l = 3;
                            } else {
                                baVar2.l = 4;
                            }
                        }
                    }
                    bb bbVar = new bb(this, (byte) 0);
                    bbVar.b = baVar2.l;
                    bbVar.a = i;
                    baVar2.c.setTag(bbVar);
                    if (TextUtils.isEmpty(facePackageData.tagUrl)) {
                        baVar2.j.setVisibility(8);
                    } else {
                        baVar2.j.setVisibility(0);
                        baVar2.j.setTag(facePackageData.tagUrl);
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "fillItemView", e.toString());
            }
        }
        if (baVar2 != null) {
            a(baVar2);
            switch (baVar2.l) {
                case 1:
                    baVar2.e.setVisibility(0);
                    break;
                case 2:
                case 3:
                case 4:
                    baVar2.c.setVisibility(0);
                    baVar2.d.setVisibility(0);
                    break;
                case 5:
                    baVar2.g.setVisibility(0);
                    break;
            }
        }
        if (baVar2 != null) {
            if (baVar2.l != 5) {
                switch (baVar2.l) {
                    case 2:
                        baVar2.d.setText((CharSequence) null);
                        if (ae != 1) {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_download_selector);
                            baVar2.d.setBackgroundResource(R.drawable.icon_content_download);
                            break;
                        } else {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_download_selector_1);
                            baVar2.d.setBackgroundResource(R.drawable.icon_content_download_1);
                            break;
                        }
                    case 3:
                        baVar2.d.setText(baVar2.k);
                        baVar2.d.setBackgroundResource(0);
                        if (ae != 1) {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
                            break;
                        } else {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
                            break;
                        }
                    case 4:
                        baVar2.d.setText(baVar2.k);
                        baVar2.d.setBackgroundResource(0);
                        if (ae != 1) {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
                            break;
                        } else {
                            baVar2.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
                            break;
                        }
                }
            } else {
                a(baVar2);
                baVar2.g.setVisibility(0);
                FacePackageData facePackageData2 = (FacePackageData) getItem(baVar2.m);
                if (facePackageData2 != null) {
                    int i5 = (int) ((((float) facePackageData2.downloadNow) / ((float) facePackageData2.downloadTotal)) * this.h);
                    int i6 = i5 < this.i ? this.i : i5;
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) baVar2.f.getLayoutParams();
                    layoutParams2.width = i6;
                    baVar2.f.setLayoutParams(layoutParams2);
                }
            }
        }
        return view;
    }

    private static void a(ba baVar) {
        if (baVar != null) {
            baVar.d.setVisibility(8);
            baVar.c.setVisibility(8);
            baVar.e.setVisibility(8);
            baVar.g.setVisibility(8);
        }
    }

    public final void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new ac();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new ay(this, facePackageData));
        }
    }

    public final void b(int i) {
        com.baidu.tieba.ai.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public final void c(int i) {
        com.baidu.tieba.ai.a(this.c, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.b != null) {
            com.baidu.tieba.f fVar = (com.baidu.tieba.f) this.c;
            fVar.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.l = new j();
            this.l.setLoadDataCallBack(new az(this, fVar, facePackageData, i));
            this.l.a(valueOf);
        }
    }

    public final com.baidu.tieba.util.i b() {
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
