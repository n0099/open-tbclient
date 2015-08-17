package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k extends PagerAdapter {
    private ArrayList<String> akH;
    private HashMap<String, ImageUrlData> akI;
    private a.d akL;
    private boolean akS;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener akJ = null;
    private a.e akK = null;
    private int akM = 0;
    private boolean akN = false;
    private String akO = null;
    private int akP = 0;
    private boolean akQ = false;
    private boolean akR = false;

    public k(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.akH = null;
        this.akL = null;
        this.mContext = context;
        this.akH = arrayList;
        this.akL = dVar;
    }

    public void setData(ArrayList<String> arrayList) {
        this.akH = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.akI = hashMap;
    }

    public void setNextTitle(String str) {
        this.akO = str;
    }

    public void setHasNext(boolean z) {
        this.akN = z;
        notifyDataSetChanged();
    }

    public boolean getHasNext() {
        return this.akN;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.akH != null) {
            i = this.akH.size();
            if (this.akN) {
                i++;
            }
        }
        return i + this.akP;
    }

    public void setTempSize(int i) {
        this.akP = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.akJ = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.akM = i;
    }

    public void a(a.e eVar) {
        this.akK = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof ae) {
            ((ae) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i == this.akH.size()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(i.f.image)).setImageDrawable(al.getDrawable(i.e.big_image_next_default));
            ((TextView) inflate.findViewById(i.f.thread_name)).setText(this.akO);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        ae aeVar = new ae(this.mContext);
        String str = i < this.akH.size() ? this.akH.get(i) : null;
        aeVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        aeVar.setImageOnClickListener(this.mOnClickListener);
        aeVar.setImageOnLongClickListener(this.akJ);
        aeVar.setIsCdn(this.akQ);
        aeVar.setOnSizeChangedListener(this.akK);
        ((ViewPager) viewGroup).addView(aeVar, 0);
        aeVar.setAssistUrl(ej(str));
        aeVar.n(str, this.akR);
        aeVar.setGifMaxUseableMem(this.akM);
        aeVar.setTag(String.valueOf(i));
        aeVar.setGifSetListener(this.akL);
        aeVar.setHeadImage(this.akS);
        return aeVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof ae) {
            i iVar = (i) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((ae) obj).getImageView();
            if (iVar.getSelectedView() == null) {
                iVar.setSelectedView(imageView);
                ViewParent parent = iVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = iVar.getCurrentView();
            if (imageView != currentView || i == this.akH.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((ae) obj).aS(this.akR);
                iVar.setCurrentView(imageView);
                if (((ae) obj).getImageType() == 1) {
                    this.akL.a(imageView);
                }
            }
        }
    }

    private ImageUrlData ej(String str) {
        if (TextUtils.isEmpty(str) || this.akI == null) {
            return null;
        }
        return this.akI.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.akR = z;
    }

    public void setIsCdn(boolean z) {
        this.akQ = z;
    }

    public void setHeadImage(boolean z) {
        this.akS = z;
    }
}
