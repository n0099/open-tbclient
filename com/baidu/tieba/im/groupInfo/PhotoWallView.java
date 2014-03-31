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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
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
    private com.baidu.tbadk.editortool.aa j;
    private ae k;
    private af l;
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
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.im.i.photo_wall_view, (ViewGroup) null));
        this.d = (LinearLayout) findViewById(com.baidu.tieba.im.h.photo_wall_container);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.im.h.first_line);
        this.f = (LinearLayout) findViewById(com.baidu.tieba.im.h.second_line);
        this.f.setVisibility(8);
        this.g = (LinearLayout) findViewById(com.baidu.tieba.im.h.lay_hint_text);
        this.h = (TextView) findViewById(com.baidu.tieba.im.h.hint_text);
        this.i = com.baidu.adp.lib.util.i.b(this.c);
        this.j = new com.baidu.tbadk.editortool.aa(this.c);
    }

    public void setData(List<PhotoUrlData> list) {
        int i;
        BDImageView bDImageView;
        boolean z;
        if (this.n != null && list != null) {
            if (this.n.size() != list.size() || list.size() == 0 || this.n.size() == 0) {
                z = false;
            } else {
                int size = this.n.size();
                z = false;
                int i2 = 0;
                while (i2 < size) {
                    if (this.n.get(i2) != null && list.get(i2) != null && this.n.get(i2).getPicId().equals(list.get(i2).getPicId())) {
                        i2++;
                        z = true;
                    } else {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                com.baidu.adp.lib.util.f.e("equal");
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
            for (int i3 = 0; i3 < size2 && i3 < 8; i3++) {
                BDImageView bDImageView2 = this.b[i3];
                if (bDImageView2 == null) {
                    BDImageView bDImageView3 = new BDImageView(this.c);
                    this.b[i3] = bDImageView3;
                    bDImageView = bDImageView3;
                } else {
                    bDImageView = bDImageView2;
                }
                bDImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (TbadkApplication.j().l() == 1) {
                    bDImageView.setBackgroundResource(com.baidu.tieba.im.g.image_group_qzl_1);
                } else {
                    bDImageView.setBackgroundResource(com.baidu.tieba.im.g.image_group_qzl);
                }
                PhotoUrlData photoUrlData2 = list.get(i3);
                if (photoUrlData2 != null) {
                    String smallurl = photoUrlData2.getSmallurl();
                    if (this.j == null) {
                        this.j = new com.baidu.tbadk.editortool.aa(this.c);
                    }
                    this.j.a(true);
                    this.j.b(smallurl, new aj(this, bDImageView));
                    bDImageView.setOnClickListener(new ag(this, photoUrlData2, i3));
                    if (this.m) {
                        bDImageView.setOnLongClickListener(new ah(this, photoUrlData2, i3));
                    }
                }
                if (i3 < 4) {
                    if (i3 == 0) {
                        this.e.addView(bDImageView, a2);
                    } else if (i3 == 3) {
                        this.e.addView(bDImageView, a3);
                    } else {
                        this.e.addView(bDImageView, a);
                    }
                } else if (i3 == 4) {
                    this.f.addView(bDImageView, a2);
                } else if (i3 == 7) {
                    this.f.addView(bDImageView, a3);
                } else {
                    this.f.addView(bDImageView, a);
                }
            }
        }
        if (list == null || list.size() == 0) {
            i = 0;
        } else {
            i = list.size();
        }
        if (this.m) {
            this.g.setVisibility(0);
            if (i == 0) {
                this.h.setText(this.c.getString(com.baidu.tieba.im.j.group_info_photo_add));
            } else {
                this.h.setText(this.c.getString(com.baidu.tieba.im.j.group_info_photo_modify));
            }
        }
        if (i < 8 && this.m) {
            BDImageView bDImageView4 = this.b[i];
            if (bDImageView4 == null) {
                bDImageView4 = new BDImageView(this.c);
                this.b[i] = bDImageView4;
            }
            bDImageView4.setImageBitmap(null);
            if (TbadkApplication.j().l() == 1) {
                bDImageView4.setBackgroundResource(com.baidu.tieba.im.g.add_group_frd_1);
            } else {
                bDImageView4.setBackgroundResource(com.baidu.tieba.im.g.add_group_frd);
            }
            bDImageView4.setOnClickListener(new ai(this, i));
            bDImageView4.setOnLongClickListener(null);
            if (i < 4) {
                if (i == 0) {
                    this.e.addView(bDImageView4, a2);
                } else if (i == 3) {
                    this.e.addView(bDImageView4, a3);
                } else {
                    this.e.addView(bDImageView4, a);
                }
            } else if (i == 4) {
                this.f.addView(bDImageView4, a2);
            } else if (i == 7) {
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

    private LinearLayout.LayoutParams a(int i) {
        int dimensionPixelSize = (this.i - (this.c.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_photo_wall_per_margin) * 6)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        int dimensionPixelSize2 = this.c.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.im_group_info_photo_wall_per_margin);
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

    public final void a() {
        for (int i = 0; i < 8; i++) {
            BDImageView bDImageView = this.b[i];
            if (bDImageView != null) {
                bDImageView.setBackgroundDrawable(null);
                bDImageView.setImageBitmap(null);
            }
        }
    }

    public void setPhotoClickListener(ae aeVar) {
        this.k = aeVar;
    }

    public void setPhotoLongClickListener(af afVar) {
        this.l = afVar;
    }

    public void setIsManager(boolean z) {
        this.m = z;
    }

    public final void a(com.baidu.tbadk.a aVar) {
        aVar.getLayoutMode().a(this.d);
    }
}
