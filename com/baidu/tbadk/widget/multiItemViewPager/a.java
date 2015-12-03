package com.baidu.tbadk.widget.multiItemViewPager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends PagerAdapter {
    private TbImageView aCA;
    private TbPageContext<?> mContext;
    private ArrayList<c> aCB = new ArrayList<>();
    private ArrayList<c> aCC = null;
    private ArrayList<View> mViewList = new ArrayList<>();
    private int agy = 2;
    private String aCD = null;
    private String aCE = null;

    public a(TbPageContext<?> tbPageContext) {
        this.mContext = tbPageContext;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mViewList == null) {
            return 0;
        }
        return this.mViewList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mViewList == null || this.mViewList.get(i) == null) {
            return null;
        }
        viewGroup.addView(this.mViewList.get(i));
        return this.mViewList.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof TbImageView) {
            viewGroup.removeView((TbImageView) obj);
        }
    }

    public void setData(ArrayList<c> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.aCC = arrayList;
            this.aCB.clear();
            this.aCB = v(arrayList);
            u(this.aCB);
        }
    }

    private void u(ArrayList<c> arrayList) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.aCA = new TbImageView(this.mContext.getPageActivity());
                this.aCA.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                this.aCA.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.aCA.setDrawBorder(true);
                this.aCA.setBorderWidth(1);
                this.aCA.d(arrayList.get(i).aCH, 10, false);
                a(this.aCA, arrayList.get(i));
                this.mViewList.add(this.aCA);
            }
        }
    }

    private ArrayList<c> v(ArrayList<c> arrayList) {
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() == 1) {
            for (int i = 0; i < 4; i++) {
                arrayList.add(arrayList.get(0));
            }
            return arrayList;
        } else if (arrayList.size() >= 2) {
            arrayList.addAll(0, arrayList.subList(arrayList.size() - this.agy, arrayList.size()));
            arrayList.addAll(arrayList.subList(2, this.agy + 2));
            return arrayList;
        } else {
            return arrayList;
        }
    }

    public void ap(String str, String str2) {
        this.aCD = str;
        this.aCE = str2;
    }

    private void a(TbImageView tbImageView, c cVar) {
        tbImageView.setOnClickListener(new b(this, cVar));
    }
}
