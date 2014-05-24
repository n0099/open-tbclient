package com.baidu.tieba.im.groupInfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PhotoWallView extends FrameLayout {
    private final int a;
    private TbImageView[] b;
    private Context c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private TextView h;
    private int i;
    private com.baidu.tbadk.editortool.ab j;
    private ae k;
    private af l;
    private boolean m;
    private List<PhotoUrlData> n;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 8;
        this.b = new TbImageView[8];
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
        this.b = new TbImageView[8];
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
        this.b = new TbImageView[8];
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
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.baidu.tieba.w.photo_wall_view, (ViewGroup) null));
        this.d = (LinearLayout) findViewById(com.baidu.tieba.v.photo_wall_container);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.v.first_line);
        this.f = (LinearLayout) findViewById(com.baidu.tieba.v.second_line);
        this.f.setVisibility(8);
        this.g = (LinearLayout) findViewById(com.baidu.tieba.v.lay_hint_text);
        this.h = (TextView) findViewById(com.baidu.tieba.v.hint_text);
        this.i = com.baidu.adp.lib.util.k.b(this.c);
        this.j = new com.baidu.tbadk.editortool.ab(this.c);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
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
                BdLog.d("equal");
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
                TbImageView tbImageView2 = this.b[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.c);
                    this.b[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultBg(null);
                tbImageView.setDefaultResource(0);
                tbImageView.setNightDefaultResource(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    tbImageView.setBackgroundResource(com.baidu.tieba.u.image_group_qzl_1);
                } else {
                    tbImageView.setBackgroundResource(com.baidu.tieba.u.image_group_qzl);
                }
                PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new ag(this, photoUrlData2, i2));
                    if (this.m) {
                        tbImageView.setOnLongClickListener(new ah(this, photoUrlData2, i2));
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.e.addView(tbImageView, a2);
                    } else if (i2 == 3) {
                        this.e.addView(tbImageView, a3);
                    } else {
                        this.e.addView(tbImageView, a);
                    }
                } else if (i2 == 4) {
                    this.f.addView(tbImageView, a2);
                } else if (i2 == 7) {
                    this.f.addView(tbImageView, a3);
                } else {
                    this.f.addView(tbImageView, a);
                }
            }
        }
        int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.m) {
            this.g.setVisibility(0);
            if (size3 == 0) {
                this.h.setText(this.c.getString(com.baidu.tieba.y.group_info_photo_add));
            } else {
                this.h.setText(this.c.getString(com.baidu.tieba.y.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.m) {
            TbImageView tbImageView4 = this.b[size3];
            if (tbImageView4 == null) {
                tbImageView4 = new TbImageView(this.c);
                this.b[size3] = tbImageView4;
            }
            tbImageView4.setImageBitmap(null);
            tbImageView4.setDefaultResource(0);
            tbImageView4.setNightDefaultResource(0);
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundResource(com.baidu.tieba.u.live_room_setting_add_selector_1);
            } else {
                tbImageView4.setBackgroundResource(com.baidu.tieba.u.live_room_setting_add_selector);
            }
            tbImageView4.setOnClickListener(new ai(this, size3));
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.e.addView(tbImageView4, a2);
                } else if (size3 == 3) {
                    this.e.addView(tbImageView4, a3);
                } else {
                    this.e.addView(tbImageView4, a);
                }
            } else if (size3 == 4) {
                this.f.addView(tbImageView4, a2);
            } else if (size3 == 7) {
                this.f.addView(tbImageView4, a3);
            } else {
                this.f.addView(tbImageView4, a);
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

    private void a(TbImageView tbImageView, String str) {
        if (this.j == null) {
            this.j = new com.baidu.tbadk.editortool.ab(this.c);
        }
        this.j.d(true);
        this.j.b(str, new aj(this, tbImageView));
    }

    private LinearLayout.LayoutParams a(int i) {
        int dimensionPixelSize = (this.i - (this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_wall_per_margin) * 6)) / 4;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        int dimensionPixelSize2 = this.c.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_wall_per_margin);
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
            TbImageView tbImageView = this.b[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageBitmap(null);
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

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().a((View) this.d);
    }
}
