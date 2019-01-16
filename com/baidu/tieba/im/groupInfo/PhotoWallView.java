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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class PhotoWallView extends FrameLayout {
    private LinearLayout aIS;
    private TbImageView[] eXH;
    private LinearLayout eXI;
    private LinearLayout eXJ;
    private LinearLayout eXK;
    private c eXL;
    private d eXM;
    private List<PhotoUrlData> eXN;
    private boolean isManager;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eXH = new TbImageView[8];
        this.aIS = null;
        this.eXI = null;
        this.eXJ = null;
        this.eXK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXH = new TbImageView[8];
        this.aIS = null;
        this.eXI = null;
        this.eXJ = null;
        this.eXK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.eXH = new TbImageView[8];
        this.aIS = null;
        this.eXI = null;
        this.eXJ = null;
        this.eXK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(e.h.photo_wall_view, (ViewGroup) null));
        this.aIS = (LinearLayout) findViewById(e.g.photo_wall_container);
        this.eXI = (LinearLayout) findViewById(e.g.first_line);
        this.eXJ = (LinearLayout) findViewById(e.g.second_line);
        this.eXJ.setVisibility(8);
        this.eXK = (LinearLayout) findViewById(e.g.lay_hint_text);
        this.mTextView = (TextView) findViewById(e.g.hint_text);
        this.mScreenWidth = l.aO(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.eXN != null && list != null) {
            if (this.eXN.size() != list.size() || list.size() == 0 || this.eXN.size() == 0) {
                z = false;
            } else {
                int size = this.eXN.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.eXN.get(i) == null || list.get(i) == null || !this.eXN.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.eXN == null) {
                    this.eXN = new ArrayList();
                }
                this.eXN.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.eXN.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.eXI.removeAllViews();
        this.eXJ.removeAllViews();
        LinearLayout.LayoutParams qr = qr(0);
        LinearLayout.LayoutParams qr2 = qr(1);
        LinearLayout.LayoutParams qr3 = qr(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.eXH[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.eXH[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(e.f.transparent_bg);
                tbImageView.setDefaultErrorResource(e.f.img_default_100);
                final PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PhotoWallView.this.eXL != null) {
                                PhotoWallView.this.eXL.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.eXM != null) {
                                    PhotoWallView.this.eXM.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.eXI.addView(tbImageView, qr2);
                    } else if (i2 == 3) {
                        this.eXI.addView(tbImageView, qr3);
                    } else {
                        this.eXI.addView(tbImageView, qr);
                    }
                } else if (i2 == 4) {
                    this.eXJ.addView(tbImageView, qr2);
                } else if (i2 == 7) {
                    this.eXJ.addView(tbImageView, qr3);
                } else {
                    this.eXJ.addView(tbImageView, qr);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.eXK.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(e.j.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(e.j.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            if (TbadkApplication.getInst().getSkinType() == 1) {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(e.d.cp_bg_line_b_1));
            } else {
                tbImageView4.setBackgroundColor(this.mContext.getResources().getColor(e.d.cp_bg_line_c));
            }
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            al.c(tbImageView4, e.f.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.eXL != null) {
                        PhotoWallView.this.eXL.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.eXI.addView(tbImageView4, qr2);
                } else if (size3 == 3) {
                    this.eXI.addView(tbImageView4, qr3);
                } else {
                    this.eXI.addView(tbImageView4, qr);
                }
            } else if (size3 == 4) {
                this.eXJ.addView(tbImageView4, qr2);
            } else if (size3 == 7) {
                this.eXJ.addView(tbImageView4, qr3);
            } else {
                this.eXJ.addView(tbImageView4, qr);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eXI.getLayoutParams();
        if (this.eXI.getChildCount() + this.eXJ.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8);
            this.eXI.setLayoutParams(layoutParams);
            this.eXJ.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.eXI.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams qr(int i) {
        LinearLayout.LayoutParams layoutParams;
        int h = l.h(this.mContext, e.C0210e.ds54);
        int i2 = (this.mScreenWidth - h) / 4;
        if (this.mScreenWidth - h <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds12);
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
            TbImageView tbImageView = this.eXH[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.eXL = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.eXM = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.aIS);
    }
}
