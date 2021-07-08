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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes3.dex */
public class ImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12885a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, ImageUrlData> f12886b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f12887c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f12888d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnLongClickListener f12889e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnTouchListener f12890f;

    /* renamed from: g  reason: collision with root package name */
    public DragImageView.k f12891g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.i f12892h;

    /* renamed from: i  reason: collision with root package name */
    public b f12893i;
    public UrlDragImageView.p j;
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

    /* loaded from: classes3.dex */
    public interface a {
        View b(ViewGroup viewGroup, int i2);

        void c(ViewGroup viewGroup, int i2);
    }

    /* loaded from: classes3.dex */
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
        this.f12887c = null;
        this.f12888d = null;
        this.f12889e = null;
        this.f12890f = null;
        this.f12891g = null;
        this.m = 0;
        this.n = false;
        this.o = null;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.f12885a = context;
        this.f12892h = iVar;
        this.l = new ArrayList();
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public final ImageUrlData c(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.f12886b) == null) {
                return null;
            }
            return map.get(str);
        }
        return (ImageUrlData) invokeL.objValue;
    }

    public final ImageUrlData d(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (map = this.f12886b) != null) {
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, viewGroup, i2, obj) == null) {
            viewGroup.removeView((View) obj);
            if (obj instanceof UrlDragImageView) {
                ((UrlDragImageView) obj).X();
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

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final UrlDragImageView f(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, viewGroup, i2)) == null) {
            String str = i2 < this.f12887c.size() ? this.f12887c.get(i2) : null;
            if (StringUtils.isNull(str) || d.a.p0.w2.a.l(str)) {
                return null;
            }
            UrlDragImageView urlDragImageView = new UrlDragImageView(this.f12885a);
            urlDragImageView.setOriImgSelectedCallback(this.j);
            urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            urlDragImageView.setImageOnClickListener(this.f12888d);
            urlDragImageView.setImageOnLongClickListener(this.f12889e);
            urlDragImageView.setOuterOnTouchListener(this.f12890f);
            urlDragImageView.setIsCanDrag(this.u);
            urlDragImageView.setIsCdn(this.r);
            urlDragImageView.setOnSizeChangedListener(this.f12891g);
            viewGroup.addView(urlDragImageView, 0);
            urlDragImageView.setAssistUrl(c(str));
            urlDragImageView.setUrl(str, this.s);
            urlDragImageView.setGifMaxUseableMem(this.m);
            urlDragImageView.setTag(String.valueOf(i2));
            urlDragImageView.setGifSetListener(this.f12892h);
            urlDragImageView.setHeadImage(this.v);
            urlDragImageView.setDragToExitListener(this.k);
            return urlDragImageView;
        }
        return (UrlDragImageView) invokeLI.objValue;
    }

    public final View g(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (this.n && i2 == getCount() - 1 && i2 != 0) {
                View inflate = LayoutInflater.from(this.f12885a).inflate(R.layout.big_image_next, (ViewGroup) null);
                ((ImageView) inflate.findViewById(R.id.image)).setImageDrawable(SkinManager.getDrawable(R.drawable.big_image_next_default));
                ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.o);
                viewGroup.addView(inflate);
                inflate.setOnClickListener(this.f12888d);
                return inflate;
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<String> arrayList = this.f12887c;
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        UrlDragImageView urlDragImageView;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if ((obj instanceof UrlDragImageView) && (imageUrlData = (urlDragImageView = (UrlDragImageView) obj).getmAssistUrlData()) != null && !StringUtils.isNull(imageUrlData.imageUrl)) {
                urlDragImageView.setAssistUrl(d(imageUrlData.imageUrl));
            }
            if (obj != this.w) {
                return -2;
            }
            return super.getItemPosition(obj);
        }
        return invokeL.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.q = i2;
            notifyDataSetChanged();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.s = z;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        List<a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, viewGroup, i2)) == null) {
            View f2 = f(viewGroup, i2);
            if (f2 == null && (list = this.l) != null && list.size() != 0) {
                Iterator<a> it = this.l.iterator();
                while (it.hasNext() && (f2 = it.next().b(viewGroup, i2)) == null) {
                }
            }
            return f2 == null ? g(viewGroup, i2) : f2;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, view, obj)) == null) ? view.equals(obj) : invokeLL.booleanValue;
    }

    public void j(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            this.f12886b = map;
            notifyDataSetChanged();
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            if (arrayList == null) {
                this.f12887c = new ArrayList<>();
            } else {
                this.f12887c = new ArrayList<>(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void l(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hVar) == null) {
            this.k = hVar;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.m = i2;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.n = z;
            notifyDataSetChanged();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.v = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.u = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.r = z;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.o = str;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            this.f12888d = onClickListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048599, this, viewGroup, i2, obj) == null) {
            super.setPrimaryItem(viewGroup, i2, obj);
            if (this.t == i2 || obj == null) {
                return;
            }
            b bVar = this.f12893i;
            if (bVar != null) {
                bVar.a(i2, obj);
            }
            this.t = i2;
            this.w = obj;
        }
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.f12889e = onLongClickListener;
        }
    }

    public void u(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.f12893i = bVar;
        }
    }

    public void v(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, kVar) == null) {
            this.f12891g = kVar;
        }
    }

    public void w(UrlDragImageView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, pVar) == null) {
            this.j = pVar;
        }
    }

    public void x(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onTouchListener) == null) {
            this.f12890f = onTouchListener;
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.p = i2;
            notifyDataSetChanged();
        }
    }
}
