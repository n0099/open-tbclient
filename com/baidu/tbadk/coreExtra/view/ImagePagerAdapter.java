package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import c.a.t0.f1.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes11.dex */
public class ImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ImageUrlData> f40841b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f40842c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f40843d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f40844e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f40845f;

    /* renamed from: g  reason: collision with root package name */
    public DragImageView.k f40846g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.i f40847h;

    /* renamed from: i  reason: collision with root package name */
    public b f40848i;

    /* renamed from: j  reason: collision with root package name */
    public UrlDragImageView.p f40849j;
    public DragImageView.h k;
    public List<a> l;
    public int m;
    public boolean n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public Object w;

    /* loaded from: classes11.dex */
    public interface a {
        View a(ViewGroup viewGroup, int i2);

        void c(ViewGroup viewGroup, int i2);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(int i2, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40842c = null;
        this.f40843d = null;
        this.f40844e = null;
        this.f40845f = null;
        this.f40846g = null;
        this.m = 0;
        this.n = false;
        this.o = null;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.a = context;
        this.f40847h = iVar;
        this.l = new ArrayList();
    }

    public final ImageUrlData a(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.f40841b) == null) {
                return null;
            }
            return map.get(str);
        }
        return (ImageUrlData) invokeL.objValue;
    }

    public void addPageProvider(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public final ImageUrlData b(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (map = this.f40841b) != null) {
                for (ImageUrlData imageUrlData : map.values()) {
                    String str2 = imageUrlData.imageUrl;
                    if (str2 != null && str2.equals(str)) {
                        return imageUrlData;
                    }
                }
            }
            return null;
        }
        return (ImageUrlData) invokeL.objValue;
    }

    public final UrlDragImageView c(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            String str = i2 < this.f40842c.size() ? this.f40842c.get(i2) : null;
            if (StringUtils.isNull(str) || c.a.t0.k3.a.l(str) || c.b(str)) {
                return null;
            }
            UrlDragImageView urlDragImageView = new UrlDragImageView(this.a);
            urlDragImageView.setOriImgSelectedCallback(this.f40849j);
            urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            urlDragImageView.setImageOnClickListener(this.f40843d);
            urlDragImageView.setImageOnLongClickListener(this.f40844e);
            urlDragImageView.setOuterOnTouchListener(this.f40845f);
            urlDragImageView.setIsCanDrag(this.u);
            urlDragImageView.setIsCdn(this.r);
            urlDragImageView.setOnSizeChangedListener(this.f40846g);
            viewGroup.addView(urlDragImageView, 0);
            urlDragImageView.setAssistUrl(a(str));
            urlDragImageView.setUrl(str, this.s);
            urlDragImageView.setGifMaxUseableMem(this.m);
            urlDragImageView.setTag(String.valueOf(i2));
            urlDragImageView.setGifSetListener(this.f40847h);
            urlDragImageView.setHeadImage(this.v);
            urlDragImageView.setDragToExitListener(this.k);
            return urlDragImageView;
        }
        return (UrlDragImageView) invokeLI.objValue;
    }

    public final View d(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            if (this.n && i2 == getCount() - 1 && i2 != 0) {
                View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(SkinManager.getDrawable(R.drawable.big_image_next_default));
                ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.o);
                viewGroup.addView(inflate);
                inflate.setOnClickListener(this.f40843d);
                return inflate;
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
            if (obj instanceof UrlDragImageView) {
                ((UrlDragImageView) obj).onDestroy();
                return;
            }
            List<a> list = this.l;
            if (list == null || list.size() == 0) {
                return;
            }
            for (a aVar : this.l) {
                if (aVar != null) {
                    aVar.c(viewGroup, i2);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<String> arrayList = this.f40842c;
            if (arrayList != null) {
                i2 = arrayList.size();
                if (this.n) {
                    i2++;
                }
            } else {
                i2 = 0;
            }
            return i2 + this.p + this.q;
        }
        return invokeV.intValue;
    }

    public boolean getHasNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj instanceof UrlDragImageView) {
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                ImageUrlData imageUrlData2 = urlDragImageView.getmAssistUrlData();
                if (imageUrlData2 != null && !StringUtils.isNull(imageUrlData2.imageUrl)) {
                    urlDragImageView.setAssistUrl(b(imageUrlData2.imageUrl));
                }
                String str = (String) ListUtils.getItem(this.f40842c, c.a.d.f.m.b.e(String.valueOf(urlDragImageView.getTag()), -1));
                if (imageUrlData2 != null && str != null && (imageUrlData = this.f40841b.get(str)) != null && (imageUrlData == imageUrlData2 || Objects.equals(imageUrlData.imageUrl, imageUrlData2.imageUrl))) {
                    return super.getItemPosition(obj);
                }
            }
            if (obj instanceof FunImageView) {
                FunImageView funImageView = (FunImageView) obj;
                if (Objects.equals(funImageView.getCurUrlTag(), ListUtils.getItem(this.f40842c, funImageView.getCurIndex()))) {
                    return super.getItemPosition(obj);
                }
                return -2;
            } else if (obj != this.w) {
                return -2;
            } else {
                return super.getItemPosition(obj);
            }
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        List<a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) {
            View c2 = c(viewGroup, i2);
            if (c2 == null && (list = this.l) != null && list.size() != 0) {
                Iterator<a> it = this.l.iterator();
                while (it.hasNext() && (c2 = it.next().a(viewGroup, i2)) == null) {
                }
            }
            return c2 == null ? d(viewGroup, i2) : c2;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view, obj)) == null) ? view.equals(obj) : invokeLL.booleanValue;
    }

    public void setAddSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.q = i2;
            notifyDataSetChanged();
        }
    }

    public void setAllowLocalUrl(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.s = z;
        }
    }

    public void setAssistUrls(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            this.f40841b = map;
            notifyDataSetChanged();
        }
    }

    public void setData(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            if (arrayList == null) {
                this.f40842c = new ArrayList<>();
            } else {
                this.f40842c = new ArrayList<>(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void setDrageToExitListener(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hVar) == null) {
            this.k = hVar;
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setHasNext(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
            notifyDataSetChanged();
        }
    }

    public void setHeadImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.v = z;
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.u = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.r = z;
        }
    }

    public void setNextTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.o = str;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.f40843d = onClickListener;
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.f40844e = onLongClickListener;
        }
    }

    public void setOnPrimaryPageChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.f40848i = bVar;
        }
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, kVar) == null) {
            this.f40846g = kVar;
        }
    }

    public void setOriImgSelectedCallback(UrlDragImageView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pVar) == null) {
            this.f40849j = pVar;
        }
    }

    public void setOuterTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onTouchListener) == null) {
            this.f40845f = onTouchListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048604, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.t == i2 || obj == null) {
                return;
            }
            b bVar = this.f40848i;
            if (bVar != null) {
                bVar.a(i2, obj);
            }
            this.t = i2;
            this.w = obj;
        }
    }

    public void setTempSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.p = i2;
            notifyDataSetChanged();
        }
    }
}
