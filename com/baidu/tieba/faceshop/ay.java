package com.baidu.tieba.faceshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ay extends BaseAdapter {
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
    View.OnClickListener a = new az(this);

    public int a() {
        return this.j;
    }

    public ay(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.g.g.b(context);
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
        int al = TiebaApplication.h().al();
        if (view == null) {
            view = a(itemViewType, viewGroup);
        }
        bc bcVar = (bc) view.getTag();
        if (this.c instanceof com.baidu.tieba.j) {
            ((com.baidu.tieba.j) this.c).getLayoutMode().a(al == 1);
            ((com.baidu.tieba.j) this.c).getLayoutMode().a(view);
        }
        a(i, bcVar);
        a(bcVar);
        a(bcVar, al);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.c);
        if (i == 1) {
            bc bcVar = new bc(this, null);
            View inflate = from.inflate(R.layout.face_shop_list_tem, (ViewGroup) null);
            bcVar.b = (TextView) inflate.findViewById(R.id.title);
            bcVar.a = (TbImageView) inflate.findViewById(R.id.image);
            bcVar.a.setDefaultResource(R.drawable.pic_baidu_logo_d);
            bcVar.a.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
            bcVar.c = (FrameLayout) inflate.findViewById(R.id.btn);
            bcVar.d = (TextView) inflate.findViewById(R.id.btn_text);
            bcVar.e = (TextView) inflate.findViewById(R.id.downloaded);
            bcVar.g = (FrameLayout) inflate.findViewById(R.id.downloading);
            bcVar.f = (ImageView) inflate.findViewById(R.id.downloading_up);
            bcVar.h = (TextView) inflate.findViewById(R.id.intro);
            bcVar.i = (TbImageView) inflate.findViewById(R.id.icon);
            bcVar.i.setDefaultResource(0);
            bcVar.i.setNightDefaultResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
            layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(R.dimen.faceshop_img_marginBottom));
            bcVar.a.setLayoutParams(layoutParams);
            bcVar.d.setClickable(false);
            bcVar.c.setClickable(true);
            bcVar.c.setOnClickListener(this.a);
            inflate.setTag(bcVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, bc bcVar) {
        if (this.b != null && bcVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    bcVar.l = i;
                    bcVar.b.setText(facePackageData.pname);
                    bcVar.h.setText(facePackageData.pdesc);
                    bcVar.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon != null && facePackageData.newIcon.length() > 0) {
                        bcVar.i.setTag(facePackageData.newIcon);
                        bcVar.i.setVisibility(0);
                    } else {
                        bcVar.i.setVisibility(8);
                    }
                    bcVar.j = facePackageData.price;
                    a(facePackageData, bcVar);
                    bd bdVar = new bd(this, null);
                    bdVar.b = bcVar.k;
                    bdVar.a = i;
                    bcVar.c.setTag(bdVar);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "fillItemView", e.toString());
            }
        }
    }

    private void a(bc bcVar) {
        if (bcVar != null) {
            b(bcVar);
            switch (bcVar.k) {
                case 1:
                    bcVar.e.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    bcVar.c.setVisibility(0);
                    bcVar.d.setVisibility(0);
                    return;
                case 5:
                    bcVar.g.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bc bcVar, int i) {
        if (bcVar != null) {
            if (bcVar.k == 5) {
                e(bcVar, i);
                return;
            }
            switch (bcVar.k) {
                case 2:
                    c(bcVar, i);
                    return;
                case 3:
                    b(bcVar, i);
                    return;
                case 4:
                    d(bcVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(bc bcVar, int i) {
        bcVar.d.setText(bcVar.j);
        bcVar.d.setBackgroundResource(0);
        if (i == 1) {
            bcVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
        } else {
            bcVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
        }
    }

    private void c(bc bcVar, int i) {
        bcVar.d.setText((CharSequence) null);
        if (i == 1) {
            bcVar.c.setBackgroundResource(R.drawable.faceshop_list_download_selector_1);
            bcVar.d.setBackgroundResource(R.drawable.icon_content_download_1);
            return;
        }
        bcVar.c.setBackgroundResource(R.drawable.faceshop_list_download_selector);
        bcVar.d.setBackgroundResource(R.drawable.icon_content_download);
    }

    private void d(bc bcVar, int i) {
        bcVar.d.setText(bcVar.j);
        bcVar.d.setBackgroundResource(0);
        if (i == 1) {
            bcVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector_1);
        } else {
            bcVar.c.setBackgroundResource(R.drawable.faceshop_list_btn_selector);
        }
    }

    private void e(bc bcVar, int i) {
        b(bcVar);
        bcVar.g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(bcVar.l);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.h);
            int i3 = i2 < this.i ? this.i : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bcVar.f.getLayoutParams();
            layoutParams.width = i3;
            bcVar.f.setLayoutParams(layoutParams);
        }
    }

    private void b(bc bcVar) {
        if (bcVar != null) {
            bcVar.d.setVisibility(8);
            bcVar.c.setVisibility(8);
            bcVar.e.setVisibility(8);
            bcVar.g.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bc bcVar) {
        if (facePackageData != null && bcVar != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                bcVar.k = 5;
            } else if (i3 == 1) {
                bcVar.k = 1;
            } else if (i == 2) {
                bcVar.k = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    bcVar.k = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    bcVar.k = 3;
                } else {
                    bcVar.k = 4;
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
            this.k.setLoadDataCallBack(new ba(this, facePackageData));
        }
    }

    public void b(int i) {
        com.baidu.tieba.ao.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        com.baidu.tieba.ao.a(this.c, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.b != null) {
            com.baidu.tieba.j jVar = (com.baidu.tieba.j) this.c;
            jVar.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.l = new j();
            this.l.setLoadDataCallBack(new bb(this, jVar, facePackageData, i));
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
