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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> alI;
    private HashMap<String, ImageUrlData> alJ;
    private a.d alM;
    private List<a> alS;
    private z.b alV;
    private boolean alW;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener alK = null;
    private a.e alL = null;
    private int alN = 0;
    private boolean alO = false;
    private String alP = null;
    private int alQ = 0;
    private int alR = 0;
    private boolean alT = false;
    private boolean alU = false;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.alI = null;
        this.alM = null;
        this.alS = null;
        this.mContext = context;
        this.alI = arrayList;
        this.alM = dVar;
        this.alS = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.alI = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.alJ = hashMap;
    }

    public void setNextTitle(String str) {
        this.alP = str;
    }

    public void setHasNext(boolean z) {
        this.alO = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.alS.add(aVar);
    }

    public boolean getHasNext() {
        return this.alO;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.alI != null) {
            i = this.alI.size();
            if (this.alO) {
                i++;
            }
        }
        return i + this.alQ + this.alR;
    }

    public void setTempSize(int i) {
        this.alQ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.alR = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alK = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.alN = i;
    }

    public void a(a.e eVar) {
        this.alL = eVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
        if (obj instanceof z) {
            ((z) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.alS.size() != 0) {
            for (a aVar : this.alS) {
                View f = aVar.f(viewGroup, i);
                if (f != null) {
                    return f;
                }
            }
        }
        View e = e(viewGroup, i);
        if (e == null) {
            return d(viewGroup, i);
        }
        return e;
    }

    private z d(ViewGroup viewGroup, int i) {
        z zVar = new z(this.mContext);
        zVar.setOriImgSelectedCallback(this.alV);
        String str = null;
        if (i < this.alI.size()) {
            str = this.alI.get(i);
        }
        zVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        zVar.setImageOnClickListener(this.mOnClickListener);
        zVar.setImageOnLongClickListener(this.alK);
        zVar.setIsCdn(this.alT);
        zVar.setOnSizeChangedListener(this.alL);
        ((ViewPager) viewGroup).addView(zVar, 0);
        zVar.setAssistUrl(eC(str));
        zVar.p(str, this.alU);
        zVar.setGifMaxUseableMem(this.alN);
        zVar.setTag(String.valueOf(i));
        zVar.setGifSetListener(this.alM);
        zVar.setHeadImage(this.alW);
        return zVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.alO && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(n.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(n.f.image)).setImageDrawable(as.getDrawable(n.e.big_image_next_default));
            ((TextView) inflate.findViewById(n.f.thread_name)).setText(this.alP);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof z) {
            i iVar = (i) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((z) obj).getImageView();
            if (iVar.getSelectedView() == null) {
                iVar.setSelectedView(imageView);
                ViewParent parent = iVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = iVar.getCurrentView();
            if (imageView != currentView || i == this.alI.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((z) obj).Ak();
                ((z) obj).aY(this.alU);
                iVar.setCurrentView(imageView);
                if (((z) obj).getImageType() == 1) {
                    this.alM.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eC(String str) {
        if (TextUtils.isEmpty(str) || this.alJ == null) {
            return null;
        }
        return this.alJ.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.alU = z;
    }

    public void setIsCdn(boolean z) {
        this.alT = z;
    }

    public void setHeadImage(boolean z) {
        this.alW = z;
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        this.alV = bVar;
    }
}
