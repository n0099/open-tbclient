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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class PhotoWallView extends FrameLayout {
    private boolean isManager;
    private TbImageView[] kkH;
    private LinearLayout kkI;
    private LinearLayout kkJ;
    private LinearLayout kkK;
    private c kkL;
    private d kkM;
    private List<PhotoUrlData> kkN;
    private LinearLayout mContainer;
    private Context mContext;
    private int mScreenWidth;
    private TextView mTextView;

    public PhotoWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kkH = new TbImageView[8];
        this.mContainer = null;
        this.kkI = null;
        this.kkJ = null;
        this.kkK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kkH = new TbImageView[8];
        this.mContainer = null;
        this.kkI = null;
        this.kkJ = null;
        this.kkK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    public PhotoWallView(Context context) {
        super(context);
        this.kkH = new TbImageView[8];
        this.mContainer = null;
        this.kkI = null;
        this.kkJ = null;
        this.kkK = null;
        this.mTextView = null;
        this.mScreenWidth = 0;
        this.isManager = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(R.layout.photo_wall_view, (ViewGroup) null));
        this.mContainer = (LinearLayout) findViewById(R.id.photo_wall_container);
        this.kkI = (LinearLayout) findViewById(R.id.first_line);
        this.kkJ = (LinearLayout) findViewById(R.id.second_line);
        this.kkJ.setVisibility(8);
        this.kkK = (LinearLayout) findViewById(R.id.lay_hint_text);
        this.mTextView = (TextView) findViewById(R.id.hint_text);
        this.mScreenWidth = l.getEquipmentWidth(this.mContext);
    }

    public void setData(List<PhotoUrlData> list) {
        TbImageView tbImageView;
        boolean z;
        if (this.kkN != null && list != null) {
            if (this.kkN.size() != list.size() || list.size() == 0 || this.kkN.size() == 0) {
                z = false;
            } else {
                int size = this.kkN.size();
                int i = 0;
                z = false;
                while (i < size) {
                    if (this.kkN.get(i) == null || list.get(i) == null || !this.kkN.get(i).getPicId().equals(list.get(i).getPicId())) {
                        z = false;
                        break;
                    } else {
                        i++;
                        z = true;
                    }
                }
            }
            if (!z) {
                if (this.kkN == null) {
                    this.kkN = new ArrayList();
                }
                this.kkN.clear();
                for (PhotoUrlData photoUrlData : list) {
                    this.kkN.add(photoUrlData);
                }
            } else {
                return;
            }
        }
        this.kkI.removeAllViews();
        this.kkJ.removeAllViews();
        LinearLayout.LayoutParams DD = DD(0);
        LinearLayout.LayoutParams DD2 = DD(1);
        LinearLayout.LayoutParams DD3 = DD(2);
        if (list != null && list.size() > 0) {
            int size2 = list.size();
            for (final int i2 = 0; i2 < size2 && i2 < 8; i2++) {
                TbImageView tbImageView2 = this.kkH[i2];
                if (tbImageView2 == null) {
                    TbImageView tbImageView3 = new TbImageView(this.mContext);
                    this.kkH[i2] = tbImageView3;
                    tbImageView = tbImageView3;
                } else {
                    tbImageView = tbImageView2;
                }
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setDefaultResource(R.drawable.transparent_bg);
                tbImageView.setDefaultErrorResource(R.drawable.img_default_100);
                final PhotoUrlData photoUrlData2 = list.get(i2);
                if (photoUrlData2 != null) {
                    a(tbImageView, photoUrlData2.getSmallurl());
                    tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PhotoWallView.this.kkL != null) {
                                PhotoWallView.this.kkL.a(view, 1, photoUrlData2, i2);
                            }
                        }
                    });
                    if (this.isManager) {
                        tbImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.2
                            @Override // android.view.View.OnLongClickListener
                            public boolean onLongClick(View view) {
                                if (PhotoWallView.this.kkM != null) {
                                    PhotoWallView.this.kkM.a(view, photoUrlData2, i2);
                                    return true;
                                }
                                return true;
                            }
                        });
                    }
                }
                if (i2 < 4) {
                    if (i2 == 0) {
                        this.kkI.addView(tbImageView, DD2);
                    } else if (i2 == 3) {
                        this.kkI.addView(tbImageView, DD3);
                    } else {
                        this.kkI.addView(tbImageView, DD);
                    }
                } else if (i2 == 4) {
                    this.kkJ.addView(tbImageView, DD2);
                } else if (i2 == 7) {
                    this.kkJ.addView(tbImageView, DD3);
                } else {
                    this.kkJ.addView(tbImageView, DD);
                }
            }
        }
        final int size3 = (list == null || list.size() == 0) ? 0 : list.size();
        if (this.isManager) {
            this.kkK.setVisibility(0);
            if (size3 == 0) {
                this.mTextView.setText(this.mContext.getString(R.string.group_info_photo_add));
            } else {
                this.mTextView.setText(this.mContext.getString(R.string.group_info_photo_modify));
            }
        }
        if (size3 < 8 && this.isManager) {
            TbImageView tbImageView4 = new TbImageView(this.mContext);
            tbImageView4.setScaleType(ImageView.ScaleType.CENTER);
            ap.setBackgroundColor(tbImageView4, R.color.CAM_X0204);
            ap.setImageResource(tbImageView4, R.drawable.icon_group_album_add);
            tbImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.PhotoWallView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PhotoWallView.this.kkL != null) {
                        PhotoWallView.this.kkL.a(view, 2, null, size3);
                    }
                }
            });
            tbImageView4.setOnLongClickListener(null);
            if (size3 < 4) {
                if (size3 == 0) {
                    this.kkI.addView(tbImageView4, DD2);
                } else if (size3 == 3) {
                    this.kkI.addView(tbImageView4, DD3);
                } else {
                    this.kkI.addView(tbImageView4, DD);
                }
            } else if (size3 == 4) {
                this.kkJ.addView(tbImageView4, DD2);
            } else if (size3 == 7) {
                this.kkJ.addView(tbImageView4, DD3);
            } else {
                this.kkJ.addView(tbImageView4, DD);
            }
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kkI.getLayoutParams();
        if (this.kkI.getChildCount() + this.kkJ.getChildCount() > 4) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds8);
            this.kkI.setLayoutParams(layoutParams);
            this.kkJ.setVisibility(0);
            return;
        }
        layoutParams.bottomMargin = 0;
        this.kkI.setLayoutParams(layoutParams);
    }

    private void a(TbImageView tbImageView, String str) {
        tbImageView.startLoad(str, 10, false);
    }

    private LinearLayout.LayoutParams DD(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimens = l.getDimens(this.mContext, R.dimen.ds54);
        int i2 = (this.mScreenWidth - dimens) / 4;
        if (this.mScreenWidth - dimens <= 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
        } else {
            layoutParams = new LinearLayout.LayoutParams(i2, i2);
        }
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
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
            TbImageView tbImageView = this.kkH[i];
            if (tbImageView != null) {
                tbImageView.setBackgroundDrawable(null);
                tbImageView.setImageDrawable(null);
            }
        }
    }

    public void setPhotoClickListener(c cVar) {
        this.kkL = cVar;
    }

    public void setPhotoLongClickListener(d dVar) {
        this.kkM = dVar;
    }

    public void setIsManager(boolean z) {
        this.isManager = z;
    }

    public void a(int i, BaseActivity baseActivity) {
        baseActivity.getLayoutMode().onModeChanged(this.mContainer);
    }
}
