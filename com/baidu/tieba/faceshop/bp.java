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
public class bp extends BaseAdapter {
    private static int d;
    private FaceShopData b;
    private final Context c;
    private final int e;
    private final int f;
    private final com.baidu.tbadk.editortool.ab g;
    private final int h;
    private final int i;
    private au k;
    private aa l;
    private int j = -1;
    View.OnClickListener a = new bq(this);

    public int a() {
        return this.j;
    }

    public bp(Context context) {
        this.c = context;
        d = com.baidu.adp.lib.util.h.b(context);
        this.e = d - (context.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_page_padding) * 2);
        this.f = (int) (this.e * 0.38495576f);
        this.g = new com.baidu.tbadk.editortool.ab(context);
        this.g.a(this.e, this.f);
        this.h = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.bg_content_download_down).getWidth();
        this.i = com.baidu.tbadk.core.util.g.a(com.baidu.tieba.q.bg_content_download_up).getWidth();
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
        bt btVar = (bt) view.getTag();
        if (this.c instanceof BaseActivity) {
            ((BaseActivity) this.c).getLayoutMode().a(skinType == 1);
            ((BaseActivity) this.c).getLayoutMode().a(view);
        }
        a(i, btVar);
        a(btVar);
        a(btVar, skinType);
        return view;
    }

    public View a(int i, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.c);
        if (i == 1) {
            bt btVar = new bt(this, null);
            View inflate = from.inflate(com.baidu.tieba.s.face_shop_list_tem, (ViewGroup) null);
            btVar.b = (TextView) inflate.findViewById(com.baidu.tieba.r.title);
            btVar.a = (TbImageView) inflate.findViewById(com.baidu.tieba.r.image);
            btVar.a.setDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d);
            btVar.a.setNightDefaultResource(com.baidu.tieba.q.pic_baidu_logo_d_1);
            btVar.c = (FrameLayout) inflate.findViewById(com.baidu.tieba.r.btn);
            btVar.d = (TextView) inflate.findViewById(com.baidu.tieba.r.btn_text);
            btVar.e = (TextView) inflate.findViewById(com.baidu.tieba.r.downloaded);
            btVar.g = (FrameLayout) inflate.findViewById(com.baidu.tieba.r.downloading);
            btVar.f = (ImageView) inflate.findViewById(com.baidu.tieba.r.downloading_up);
            btVar.h = (TextView) inflate.findViewById(com.baidu.tieba.r.intro);
            btVar.i = (TbImageView) inflate.findViewById(com.baidu.tieba.r.icon);
            btVar.i.setDefaultResource(0);
            btVar.i.setNightDefaultResource(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.e, this.f);
            layoutParams.setMargins(0, 0, 0, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.p.faceshop_img_marginBottom));
            btVar.a.setLayoutParams(layoutParams);
            btVar.d.setClickable(false);
            btVar.c.setClickable(true);
            btVar.c.setOnClickListener(this.a);
            btVar.j = (TbImageView) inflate.findViewById(com.baidu.tieba.r.title_tag);
            inflate.setTag(btVar);
            return inflate;
        }
        return null;
    }

    private void a(int i, bt btVar) {
        if (this.b != null && btVar != null) {
            try {
                FacePackageData facePackageData = (FacePackageData) getItem(i);
                if (facePackageData != null) {
                    btVar.m = i;
                    btVar.b.setText(facePackageData.pname);
                    btVar.h.setText(facePackageData.pdesc);
                    btVar.a.setTag(facePackageData.bannerUrl);
                    if (facePackageData.newIcon != null && facePackageData.newIcon.length() > 0) {
                        btVar.i.setTag(facePackageData.newIcon);
                        btVar.i.setVisibility(0);
                    } else {
                        btVar.i.setVisibility(8);
                    }
                    btVar.k = facePackageData.price;
                    a(facePackageData, btVar);
                    bu buVar = new bu(this, null);
                    buVar.b = btVar.l;
                    buVar.a = i;
                    btVar.c.setTag(buVar);
                    if (!TextUtils.isEmpty(facePackageData.tagUrl)) {
                        btVar.j.setVisibility(0);
                        btVar.j.setTag(facePackageData.tagUrl);
                        return;
                    }
                    btVar.j.setVisibility(8);
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "fillItemView", e.toString());
            }
        }
    }

    private void a(bt btVar) {
        if (btVar != null) {
            b(btVar);
            switch (btVar.l) {
                case 1:
                    btVar.e.setVisibility(0);
                    return;
                case 2:
                case 3:
                case 4:
                    btVar.c.setVisibility(0);
                    btVar.d.setVisibility(0);
                    return;
                case 5:
                    btVar.g.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(bt btVar, int i) {
        if (btVar != null) {
            if (btVar.l == 5) {
                e(btVar, i);
                return;
            }
            switch (btVar.l) {
                case 2:
                    c(btVar, i);
                    return;
                case 3:
                    b(btVar, i);
                    return;
                case 4:
                    d(btVar, i);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(bt btVar, int i) {
        btVar.d.setText(btVar.k);
        btVar.d.setBackgroundResource(0);
        if (i == 1) {
            btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector_1);
        } else {
            btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector);
        }
    }

    private void c(bt btVar, int i) {
        btVar.d.setText((CharSequence) null);
        if (i == 1) {
            btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_download_selector_1);
            btVar.d.setBackgroundResource(com.baidu.tieba.q.icon_content_download_1);
            return;
        }
        btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_download_selector);
        btVar.d.setBackgroundResource(com.baidu.tieba.q.icon_content_download);
    }

    private void d(bt btVar, int i) {
        btVar.d.setText(btVar.k);
        btVar.d.setBackgroundResource(0);
        if (i == 1) {
            btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector_1);
        } else {
            btVar.c.setBackgroundResource(com.baidu.tieba.q.faceshop_list_btn_selector);
        }
    }

    private void e(bt btVar, int i) {
        b(btVar);
        btVar.g.setVisibility(0);
        FacePackageData facePackageData = (FacePackageData) getItem(btVar.m);
        if (facePackageData != null) {
            int i2 = (int) ((((float) facePackageData.downloadNow) / ((float) facePackageData.downloadTotal)) * this.h);
            int i3 = i2 < this.i ? this.i : i2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) btVar.f.getLayoutParams();
            layoutParams.width = i3;
            btVar.f.setLayoutParams(layoutParams);
        }
    }

    private void b(bt btVar) {
        if (btVar != null) {
            btVar.d.setVisibility(8);
            btVar.c.setVisibility(8);
            btVar.e.setVisibility(8);
            btVar.g.setVisibility(8);
        }
    }

    private void a(FacePackageData facePackageData, bt btVar) {
        if (facePackageData != null && btVar != null) {
            int i = facePackageData.buyStatus;
            int i2 = facePackageData.canDownload;
            int i3 = facePackageData.downloaded;
            if (facePackageData.downloading == 1) {
                btVar.l = 5;
            } else if (i3 == 1) {
                btVar.l = 1;
            } else if (i == 2) {
                btVar.l = 6;
            } else if (i == 1) {
                if (i2 == 1) {
                    btVar.l = 2;
                }
            } else if (i == 0) {
                if (i2 == 1) {
                    btVar.l = 3;
                } else {
                    btVar.l = 4;
                }
            }
        }
    }

    public void a(int i) {
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.downloading = 1;
            notifyDataSetChanged();
            this.k = new au();
            this.k.a(String.valueOf(facePackageData.pid));
            this.k.setLoadDataCallBack(new br(this, facePackageData));
        }
    }

    public void b(int i) {
        com.baidu.tbadk.core.g.a(this.c, "emotion_package_list_free");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (facePackageData != null) {
            facePackageData.buyStatus = 1;
            notifyDataSetChanged();
        }
    }

    public void c(int i) {
        com.baidu.tbadk.core.g.a(this.c, "emotion_package_list_buy");
        FacePackageData facePackageData = (FacePackageData) getItem(i);
        if (this.b != null) {
            BaseActivity baseActivity = (BaseActivity) this.c;
            baseActivity.showProgressBar();
            String valueOf = String.valueOf(facePackageData.pid);
            this.l = new aa();
            this.l.setLoadDataCallBack(new bs(this, baseActivity, facePackageData, i));
            this.l.a(valueOf);
        }
    }

    public com.baidu.tbadk.editortool.ab b() {
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
