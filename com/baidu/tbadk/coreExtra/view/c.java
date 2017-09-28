package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.view.f;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends PagerAdapter {
    private ArrayList<String> auE;
    private Map<String, ImageUrlData> auF;
    private a.e auJ;
    private List<a> auP;
    private a.d auQ;
    private f.b auT;
    private boolean auV;
    private Context mContext;
    private View.OnClickListener mOnClickListener = null;
    private View.OnLongClickListener auG = null;
    private View.OnTouchListener auH = null;
    private a.f auI = null;
    private int auK = 0;
    private boolean auL = false;
    private String auM = null;
    private int auN = 0;
    private int auO = 0;
    private boolean auR = false;
    private boolean auS = false;
    private int auU = -1;

    /* loaded from: classes.dex */
    public interface a {
        View e(ViewGroup viewGroup, int i);
    }

    public c(Context context, ArrayList<String> arrayList, a.e eVar) {
        this.mContext = null;
        this.auE = null;
        this.auJ = null;
        this.auP = null;
        this.mContext = context;
        this.auE = arrayList;
        this.auJ = eVar;
        this.auP = new ArrayList();
    }

    public void setData(ArrayList<String> arrayList) {
        this.auE = arrayList;
        notifyDataSetChanged();
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        this.auF = map;
    }

    public void setNextTitle(String str) {
        this.auM = str;
    }

    public void setHasNext(boolean z) {
        this.auL = z;
        notifyDataSetChanged();
    }

    public void a(a aVar) {
        this.auP.add(aVar);
    }

    public boolean getHasNext() {
        return this.auL;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        int i = 0;
        if (this.auE != null) {
            i = this.auE.size();
            if (this.auL) {
                i++;
            }
        }
        return i + this.auN + this.auO;
    }

    public void setTempSize(int i) {
        this.auN = i;
        notifyDataSetChanged();
    }

    public void setAddSize(int i) {
        this.auO = i;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.auH = onTouchListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.auG = onLongClickListener;
    }

    public void setGifMaxUseableMem(int i) {
        this.auK = i;
    }

    public void a(a.f fVar) {
        this.auI = fVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
        if (obj instanceof f) {
            ((f) obj).onDestroy();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View c = c(viewGroup, i);
        if (c == null && this.auP.size() != 0) {
            Iterator<a> it = this.auP.iterator();
            while (it.hasNext() && (c = it.next().e(viewGroup, i)) == null) {
            }
        }
        if (c == null) {
            return d(viewGroup, i);
        }
        return c;
    }

    private f c(ViewGroup viewGroup, int i) {
        String str = i < this.auE.size() ? this.auE.get(i) : null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        f fVar = new f(this.mContext);
        fVar.setOriImgSelectedCallback(this.auT);
        fVar.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        fVar.setImageOnClickListener(this.mOnClickListener);
        fVar.setImageOnLongClickListener(this.auG);
        fVar.setOuterOnTouchListener(this.auH);
        fVar.setIsCdn(this.auR);
        fVar.setOnSizeChangedListener(this.auI);
        viewGroup.addView(fVar, 0);
        fVar.setAssistUrl(eZ(str));
        fVar.n(str, this.auS);
        fVar.setGifMaxUseableMem(this.auK);
        fVar.setTag(String.valueOf(i));
        fVar.setGifSetListener(this.auJ);
        fVar.setHeadImage(this.auV);
        fVar.setDragToExitListener(this.auQ);
        return fVar;
    }

    public void setDrageToExitListener(a.d dVar) {
        this.auQ = dVar;
    }

    private View d(ViewGroup viewGroup, int i) {
        if (this.auL && i == getCount() - 1 && i != 0) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(d.h.image)).setImageDrawable(aj.getDrawable(d.g.big_image_next_default));
            ((TextView) inflate.findViewById(d.h.thread_name)).setText(this.auM);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.mOnClickListener);
            return inflate;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        boolean z;
        super.setPrimaryItem(viewGroup, i, obj);
        if (obj instanceof f) {
            if (this.auU == i) {
                z = false;
            } else {
                this.auU = i;
                z = true;
            }
            b bVar = (b) viewGroup;
            com.baidu.tbadk.widget.a imageView = ((f) obj).getImageView();
            if (bVar.getSelectedView() == null) {
                bVar.setSelectedView(imageView);
                ViewParent parent = bVar.getParent();
                if (parent != null && (parent instanceof MultiImageView)) {
                    ((MultiImageView) parent).setZoomButton(imageView);
                }
            }
            com.baidu.tbadk.widget.a currentView = bVar.getCurrentView();
            if (imageView != currentView || i == this.auE.size() - 1) {
                if (currentView != null) {
                    currentView.Hp();
                }
                ((f) obj).Bd();
                ((f) obj).j(this.auS, z);
                bVar.setCurrentView(imageView);
                if (((f) obj).getImageType() == 1) {
                    this.auJ.a(imageView);
                }
            }
        }
    }

    private ImageUrlData eZ(String str) {
        if (TextUtils.isEmpty(str) || this.auF == null) {
            return null;
        }
        return this.auF.get(str);
    }

    public void setAllowLocalUrl(boolean z) {
        this.auS = z;
    }

    public void setIsCdn(boolean z) {
        this.auR = z;
    }

    public void setHeadImage(boolean z) {
        this.auV = z;
    }

    public void setOriImgSelectedCallback(f.b bVar) {
        this.auT = bVar;
    }
}
