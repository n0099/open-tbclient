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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout awj;
    private TbImageView[] ewX;
    private LinearLayout ewY;
    private LinearLayout ewZ;
    private LinearLayout exa;
    private c exb;
    private d exc;
    private List<PhotoUrlData> exd;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ewX = new TbImageView[8];
        this.awj = null;
        this.ewY = null;
        this.ewZ = null;
        this.exa = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ewX = new TbImageView[8];
        this.awj = null;
        this.ewY = null;
        this.ewZ = null;
        this.exa = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.ewX = new TbImageView[8];
        this.awj = null;
        this.ewY = null;
        this.ewZ = null;
        this.exa = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(d.h.photo_wall_view, (ViewGroup) null));
        this.awj = (LinearLayout) findViewById(d.g.photo_wall_container);
        this.ewY = (LinearLayout) findViewById(d.g.first_line);
        this.ewZ = (LinearLayout) findViewById(d.g.second_line);
        this.ewZ.setVisibility(8);
        this.exa = (LinearLayout) findViewById(d.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(d.g.hint_text);
        this.mScreenWidth = l.ah(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.exd != null && list != null) {
            if (this.exd.size() != list.size() || list.size() == 0 || this.exd.size() == 0) {
                z = false;
            } else {
                int size = this.exd.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.exd.get(i) == null || list.get(i) == null || !this.exd.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.exd == null) {
                    this.exd = new ArrayList();
                }
                this.exd.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.exd.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.ewY.removeAllViews();
        this.ewZ.removeAllViews();
        LinearLayout.LayoutParams oo = oo(0);
        LinearLayout.LayoutParams oo2 = oo(1);
        LinearLayout.LayoutParams oo3 = oo(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.ewX[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.ewX[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(d.f.transparent_bg);
                tbImageView.setDefaultErrorResource(d.f.img_default_100);
                final PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PhotoWallView.this.exb != null) {
                                PhotoWallView.this.exb.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.exc != null) {
                                    PhotoWallView.this.exc.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.ewY.addView(tbImageView, oo2);
                    } else if (i2 == 3) {
                        this.ewY.addView(tbImageView, oo3);
                    } else {
                        this.ewY.addView(tbImageView, oo);
                    }
                } else if (i2 == 4) {
                    this.ewZ.addView(tbImageView, oo2);
                } else if (i2 == 7) {
                    this.ewZ.addView(tbImageView, oo3);
                } else {
                    this.ewZ.addView(tbImageView, oo);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.exa.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(d.j.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(d.j.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0140d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(d.C0140d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            am.c(tbImageView4, d.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.exb != null) {
                        PhotoWallView.this.exb.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.ewY.addView(tbImageView4, oo2);
                } else if (size3 == 3) {
                    this.ewY.addView(tbImageView4, oo3);
                } else {
                    this.ewY.addView(tbImageView4, oo);
                }
            } else if (size3 == 4) {
                this.ewZ.addView(tbImageView4, oo2);
            } else if (size3 == 7) {
                this.ewZ.addView(tbImageView4, oo3);
            } else {
                this.ewZ.addView(tbImageView4, oo);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ewY.getLayoutParams();
        if (this.ewY.getChildCount() + this.ewZ.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            this.ewY.setLayoutParams(layoutParams);
            this.ewZ.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.ewY.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams oo(int i) {
        LinearLayout.LayoutParams layoutParams;
        int f = l.f(this.mContext, d.e.ds54);
        int i2 = (this.mScreenWidth - f) / 4;
        if (this.mScreenWidth - f <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        if (i == 0) {
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = 0;
        } else if (i == 1) {
            layoutParams.leftMargin = dimensionPixelSize2;
            layoutParams.rightMargin = 0;
        } else if (i == 2) {
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize2;
        }
        return layoutParams;
    }

    public void onDestory() {
        for (int i = 0; i < 8; i++) {
            TbImageView tbImageView = this.ewX[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.exb = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.exc = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.awj);
    }
}
