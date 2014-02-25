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
public class aw extends BaseAdapter {
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

    public int a() {
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
        int al = TiebaApplication.g().al();
        if (view == null) {
            view = a(itemViewType, viewGroup);
        }
        ba baVar = (ba) view.getTag();
        if (this.c instanceof com.baidu.tieba.f) {
            ((com.baidu.tieba.f) this.c).getLayoutMode().a(al == 1);
            ((com.baidu.tieba.f) this.c).getLayoutMode().a(view);
        }
        a(i, baVar);
        a(baVar);
        a(baVar, al);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.c);
        if (i == 1) {
            ba baVar = new ba(this, null);
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
            return inflate;
        }
        return null;
    }

    private void a(int i, ba baVar) {
        if (this.b != null && baVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    baVar.m = i;
                    baVar.b.setText(facePackageData.pname);
                    baVar.h.setText(facePackageData.pdesc);
                    baVar.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon != null && facePackageData.newIcon.length() > 0) {
                        baVar.i.setTag(facePackageData.newIcon);
                        baVar.i.setVisibility(0);
                    } else {
                        baVar.i.setVisibility(8);
                    }
                    baVar.k = facePackageData.price;
                    a(facePackageData, baVar);
                    bb bbVar = new bb(this, null);
                    bbVar.b = baVar.l;
                    bbVar.a = i;
                    baVar.c.setTag(bbVar);
                    if (!TextUtils.isEmpty(facePackageData.tagUrl)) {
                        baVar.j.setVisibility(0);
                        baVar.j.setTag(facePackageData.tagUrl);
                        return;
                    }
                    baVar.j.setVisibility(8);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "fillItemView", e.toString());
            }
        }
    }

    private void a(ba baVar) {
        if (baVar != null) {
            b(baVar);
            switch (baVar.l) {
                case 1:
                    baVar.e.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    baVar.c.setVisibility(0);
                    baVar.d.setVisibility(0);
                    return;
                case 5:
                    baVar.g.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(ba baVar, int i) {
        if (baVar != null) {
            if (baVar.l == 5) {
                e(baVar, i);
                return;
            }
            switch (baVar.l) {
                case 2:
                    c(baVar, i);
                    return;
                case 3:
                    b(baVar, i);
                    return;
                case 4:
                    d(baVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(ba baVar, int i) {
        baVar.d.setText(baVar.k);
        baVar.d.setBackgroundResource(0);
        if (i == 1) {
            baVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
        } else {
            baVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
        }
    }

    private void c(ba baVar, int i) {
        baVar.d.setText((CharSequence) null);
        if (i == 1) {
            baVar.c.setBackgroundResource(R.drawable.faceshop_list_download_selector_1);
            baVar.d.setBackgroundResource(R.drawable.icon_content_download_1);
            return;
        }
        baVar.c.setBackgroundResource(R.drawable.faceshop_list_download_selector);
        baVar.d.setBackgroundResource(R.drawable.icon_content_download);
    }

    private void d(ba baVar, int i) {
        baVar.d.setText(baVar.k);
        baVar.d.setBackgroundResource(0);
        if (i == 1) {
            baVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
        } else {
            baVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
        }
    }

    private void e(ba baVar, int i) {
        b(baVar);
        baVar.g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(baVar.m);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.h);
            int i3 = i2 < this.i ? this.i : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) baVar.f.getLayoutParams();
            layoutParams.width = i3;
            baVar.f.setLayoutParams(layoutParams);
        }
    }

    private void b(ba baVar) {
        if (baVar != null) {
            baVar.d.setVisibility(8);
            baVar.c.setVisibility(8);
            baVar.e.setVisibility(8);
            baVar.g.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, ba baVar) {
        if (facePackageData != null && baVar != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                baVar.l = 5;
            } else if (i3 == 1) {
                baVar.l = 1;
            } else if (i == 2) {
                baVar.l = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    baVar.l = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    baVar.l = 3;
                } else {
                    baVar.l = 4;
                }
            }
        }
    }

    public void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new ac();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new ay(this, facePackageData));
        }
    }

    public void b(int i) {
        com.baidu.tieba.ai.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
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

    public com.baidu.tieba.util.i b() {
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
