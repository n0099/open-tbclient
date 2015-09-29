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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.z;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class j extends PagerAdapter {
    private ArrayList<String> ajR;
    private HashMap<String, ImageUrlData> ajS;
    private a.d ajV;
    private List<a> akb;
    private z.b ake;
    private boolean akf;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener ajT = null;
    private a.e ajU = null;
    private int ajW = 0;
    private boolean ajX = false;
    private String ajY = null;
    private int ajZ = 0;
    private int aka = 0;
    private boolean akc = false;
    private boolean akd = false;

    /* loaded from: classes.dex */
    public interface a {
        View f(ViewGroup viewGroup, int i);
    }

    public j(Context context, ArrayList<String> arrayList, a.d dVar) {
        this.mContext = null;
        this.ajR = null;
        this.ajV = null;
        this.akb = null;
        this.mContext = context;
        this.ajR = arrayList;
        this.ajV = dVar;
        this.akb = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.ajR = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(HashMap<String, ImageUrlData> hashMap) {
        this.ajS = hashMap;
    }

    public void setNextTitle(String str) {
        this.ajY = str;
    }

    public void setHasNext(boolean z) {
        this.ajX = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.akb.add(aVar);
    }

    public boolean getHasNext() {
        return this.ajX;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.ajR != null) {
            i = this.ajR.size();
            if (this.ajX) {
                i++;
            }
        }
        return i + this.ajZ + this.aka;
    }

    public void setTempSize(int i) {
        this.ajZ = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.aka = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ajT = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.ajW = i;
    }

    public void a(a.e eVar) {
        this.ajU = eVar;
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
        if (this.akb.size() != 0) {
            for (a aVar : this.akb) {
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
        zVar.setOriImgSelectedCallback(this.ake);
        String str = null;
        if (i < this.ajR.size()) {
            str = this.ajR.get(i);
        }
        zVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        zVar.setImageOnClickListener(this.mOnClickListener);
        zVar.setImageOnLongClickListener(this.ajT);
        zVar.setIsCdn(this.akc);
        zVar.setOnSizeChangedListener(this.ajU);
        ((ViewPager) viewGroup).addView(zVar, 0);
        zVar.setAssistUrl(es(str));
        zVar.p(str, this.akd);
        zVar.setGifMaxUseableMem(this.ajW);
        zVar.setTag(String.valueOf(i));
        zVar.setGifSetListener(this.ajV);
        zVar.setHeadImage(this.akf);
        return zVar;
    }

    private View e(ViewGroup viewGroup, int i) {
        if (this.ajX && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(i.g.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(i.f.image)).setImageDrawable(am.getDrawable(i.e.big_image_next_default));
            ((TextView) inflate.findViewById(i.f.thread_name)).setText(this.ajY);
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
            if (imageView != currentView || i == this.ajR.size() - 1) {
                if (currentView != null) {
                    currentView.restoreSize();
                }
                ((z) obj).zm();
                ((z) obj).aT(this.akd);
                iVar.setCurrentView(imageView);
                if (((z) obj).getImageType() == 1) {
                    this.ajV.a(imageView);
                }
            }
        }
    }

    private ImageUrlData es(String str) {
        if (TextUtils.isEmpty(str) || this.ajS == null) {
            return null;
        }
        return this.ajS.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.akd = z;
    }

    public void setIsCdn(boolean z) {
        this.akc = z;
    }

    public void setHeadImage(boolean z) {
        this.akf = z;
    }

    public void setOriImgSelectedCallback(z.b bVar) {
        this.ake = bVar;
    }
}
