package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.PhotoUrlData;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PhotoWallView extends FrameLayout {
    private final int a;
    private BDImageView[] b;
    private Context c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private TextView h;
    private int i;
    private com.baidu.tieba.util.i j;
    private y k;
    private z l;
    private boolean m;
    private List<PhotoUrlData> n;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 8;
        this.b = new BDImageView[8];
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.m = false;
        a(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 8;
        this.b = new BDImageView[8];
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.m = false;
        a(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.a = 8;
        this.b = new BDImageView[8];
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.m = false;
        a(context);
    }

    private void a(Context context) {
        this.c = context;
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.photo_wall_view, (ViewGroup) null));
        this.d = (LinearLayout) findViewById(R.id.photo_wall_container);
        this.e = (LinearLayout) findViewById(R.id.first_line);
        this.f = (LinearLayout) findViewById(R.id.second_line);
        this.f.setVisibility(8);
        this.g = (LinearLayout) findViewById(R.id.lay_hint_text);
        this.h = (TextView) findViewById(R.id.hint_text);
        this.i = com.baidu.adp.lib.h.g.b(this.c);
        this.j = new com.baidu.tieba.util.i(this.c);
    }

    public void setData(List<PhotoUrlData> list) {
        BDImageView bDImageView;
        boolean z;
        if (this.n != null && list != null) {
            if (this.n.size() != list.size() || list.size() == 0 || this.n.size() == 0) {
                z = false;
            } else {
                int size = this.n.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.n.get(i) == null || list.get(i) == null || !this.n.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (z) {
                com.baidu.adp.lib.h.e.d("equal");
                return;
            }
            if (this.n == null) {
                this.n = new ArrayList();
            }
            this.n.clear();
            for (PhotoUrlData photoUrlData : list) {
                this.n.add(photoUrlData);
            }
        }
        this.e.removeAllViews();
        this.f.removeAllViews();
        LinearLayout.LayoutParams a = a(0);
        LinearLayout.LayoutParams a2 = a(1);
        LinearLayout.LayoutParams a3 = a(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                BDImageView bDImageView2 = this.b[i2];
                if (bDImageView2 == null) {
                    BDImageView bDImageView3 = new BDImageView(this.c);
                    this.b[i2] = bDImageView3;
                    bDImageView = bDImageView3;
                } else {
                    bDImageView = bDImageView2;
                }
                bDImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (TiebaApplication.g().an() == 1) {
                    bDImageView.setBackgroundResource(R.drawable.image_group_qzl_1);
                } else {
                    bDImageView.setBackgroundResource(R.drawable.image_group_qzl);
                }
                PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(bDImageView, photoUrlData2.getSmallurl());
                    bDImageView.setOnClickListener(new aa(this, photoUrlData2, i2));
                    if (this.m) {
                        bDImageView.setOnLongClickListener(new ab(this, photoUrlData2, i2));
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.e.addView(bDImageView, a2);
                    } else if (i2 == 3) {
                        this.e.addView(bDImageView, a3);
                    } else {
                        this.e.addView(bDImageView, a);
                    }
                } else if (i2 == 4) {
                    this.f.addView(bDImageView, a2);
                } else if (i2 == 7) {
                    this.f.addView(bDImageView, a3);
                } else {
                    this.f.addView(bDImageView, a);
                }
            }
        }
        int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.m) {
            this.g.setVisibility(0);
            if (size3 == 0) {
                this.h.setText(this.c.getString(R.string.group_info_photo_add));
            } else {
                this.h.setText(this.c.getString(R.string.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.m) {
            BDImageView bDImageView4 = this.b[size3];
            if (bDImageView4 == null) {
                bDImageView4 = new BDImageView(this.c);
                this.b[size3] = bDImageView4;
            }
            bDImageView4.setImageBitmap(null);
            if (TiebaApplication.g().an() == 1) {
                bDImageView4.setBackgroundResource(R.drawable.add_group_frd_1);
            } else {
                bDImageView4.setBackgroundResource(R.drawable.add_group_frd);
            }
            bDImageView4.setOnClickListener(new ac(this, size3));
            bDImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.e.addView(bDImageView4, a2);
                } else if (size3 == 3) {
                    this.e.addView(bDImageView4, a3);
                } else {
                    this.e.addView(bDImageView4, a);
                }
            } else if (size3 == 4) {
                this.f.addView(bDImageView4, a2);
            } else if (size3 == 7) {
                this.f.addView(bDImageView4, a3);
            } else {
                this.f.addView(bDImageView4, a);
            }
        }
        if (this.e.getChildCount() + this.f.getChildCount() > 4) {
            this.f.setVisibility(0);
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.e.setLayoutParams(layoutParams);
    }

    private void a(BDImageView bDImageView, String str) {
        if (this.j == null) {
            this.j = new com.baidu.tieba.util.i(this.c);
        }
        this.j.d(true);
        com.baidu.adp.widget.ImageView.d a = this.j.a(str, new ad(this, bDImageView));
        if (a != null) {
            bDImageView.setBackgroundDrawable(null);
            bDImageView.setImageBitmap(null);
            a.a(bDImageView);
        }
    }

    private LinearLayout.LayoutParams a(int i) {
        int dimensionPixelSize = (this.i - (this.c.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_wall_per_margin) * 6)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        int dimensionPixelSize2 = this.c.getResources().getDimensionPixelSize(R.dimen.im_group_info_photo_wall_per_margin);
        if (i == 0) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = dimensionPixelSize2;
        } else if (i == 1) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = dimensionPixelSize2;
        } else if (i == 2) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = 0;
        }
        return layoutParams;
    }

    public void a() {
        for (int i = 0; i < 8; i++) {
            BDImageView bDImageView = this.b[i];
            if (bDImageView != null) {
                bDImageView.setBackgroundDrawable(null);
                bDImageView.setImageBitmap(null);
            }
        }
    }

    public void setPhotoClickListener(y yVar) {
        this.k = yVar;
    }

    public void setPhotoLongClickListener(z zVar) {
        this.l = zVar;
    }

    public void setIsManager(boolean z) {
        this.m = z;
    }

    public void a(int i, com.baidu.tieba.j jVar) {
        jVar.getLayoutMode().a(this.d);
    }
}
