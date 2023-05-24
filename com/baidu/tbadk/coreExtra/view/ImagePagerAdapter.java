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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.af9;
import com.baidu.tieba.pg;
import com.baidu.tieba.pn7;
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
/* loaded from: classes4.dex */
public class ImagePagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Map<String, ImageUrlData> b;
    public ArrayList<String> c;
    public View.OnClickListener d;
    public View.OnLongClickListener e;
    public View.OnTouchListener f;
    public DragImageView.k g;
    public DragImageView.i h;
    public b i;
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

    /* loaded from: classes4.dex */
    public interface a {
        View a(ViewGroup viewGroup, int i);

        void c(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, Object obj);
    }

    public ImagePagerAdapter(Context context, DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, iVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.m = 0;
        this.n = false;
        this.o = null;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = -1;
        this.a = context;
        this.h = iVar;
        this.l = new ArrayList();
    }

    public final View g(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) {
            if (!this.n || i != getCount() - 1 || i == 0) {
                return null;
            }
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.big_image_next, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091034)).setImageDrawable(SkinManager.getDrawable(R.drawable.big_image_next_default));
            ((TextView) inflate.findViewById(R.id.thread_name)).setText(this.o);
            viewGroup.addView(inflate);
            inflate.setOnClickListener(this.d);
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.p = i;
            notifyDataSetChanged();
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.l.add(aVar);
        }
    }

    public final ImageUrlData c(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (map = this.b) != null) {
                return map.get(str);
            }
            return null;
        }
        return (ImageUrlData) invokeL.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.q = i;
            notifyDataSetChanged();
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.s = z;
        }
    }

    public void j(Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, map) == null) {
            this.b = map;
            notifyDataSetChanged();
        }
    }

    public void k(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
            if (arrayList == null) {
                this.c = new ArrayList<>();
            } else {
                this.c = new ArrayList<>(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public void l(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hVar) == null) {
            this.k = hVar;
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.m = i;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.n = z;
            notifyDataSetChanged();
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.v = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.u = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.r = z;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.o = str;
        }
    }

    public void s(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.d = onClickListener;
        }
    }

    public void t(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.e = onLongClickListener;
        }
    }

    public void u(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void x(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, kVar) == null) {
            this.g = kVar;
        }
    }

    public void y(UrlDragImageView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, pVar) == null) {
            this.j = pVar;
        }
    }

    public void z(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onTouchListener) == null) {
            this.f = onTouchListener;
        }
    }

    public final ImageUrlData d(String str) {
        InterceptResult invokeL;
        Map<String, ImageUrlData> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (map = this.b) != null) {
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
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
            viewGroup.removeView((View) obj);
            if (obj instanceof UrlDragImageView) {
                ((UrlDragImageView) obj).Y();
                return;
            }
            List<a> list = this.l;
            if (list != null && list.size() != 0) {
                for (a aVar : this.l) {
                    if (aVar != null) {
                        aVar.c(viewGroup, i);
                    }
                }
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<String> arrayList = this.c;
            if (arrayList != null) {
                i = arrayList.size();
                if (this.n) {
                    i++;
                }
            } else {
                i = 0;
            }
            return i + this.p + this.q;
        }
        return invokeV.intValue;
    }

    public final UrlDragImageView f(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i)) == null) {
            if (i < this.c.size()) {
                str = this.c.get(i);
            } else {
                str = null;
            }
            if (StringUtils.isNull(str) || af9.j(str) || pn7.d(str) || str.startsWith("####mLiveRoomPageProvider")) {
                return null;
            }
            UrlDragImageView urlDragImageView = new UrlDragImageView(this.a);
            urlDragImageView.setOriImgSelectedCallback(this.j);
            urlDragImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            urlDragImageView.setImageOnClickListener(this.d);
            urlDragImageView.setImageOnLongClickListener(this.e);
            urlDragImageView.setOuterOnTouchListener(this.f);
            urlDragImageView.setIsCanDrag(this.u);
            urlDragImageView.setIsCdn(this.r);
            urlDragImageView.setOnSizeChangedListener(this.g);
            viewGroup.addView(urlDragImageView, 0);
            urlDragImageView.setAssistUrl(c(str));
            urlDragImageView.setUrl(str, this.s);
            urlDragImageView.setGifMaxUseableMem(this.m);
            urlDragImageView.setTag(String.valueOf(i));
            urlDragImageView.setGifSetListener(this.h);
            urlDragImageView.setHeadImage(this.v);
            urlDragImageView.setDragToExitListener(this.k);
            return urlDragImageView;
        }
        return (UrlDragImageView) invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj instanceof UrlDragImageView) {
                UrlDragImageView urlDragImageView = (UrlDragImageView) obj;
                if (urlDragImageView.N() && urlDragImageView.getImageView().getImageBitmap() == null) {
                    return -2;
                }
                ImageUrlData imageUrlData2 = urlDragImageView.getmAssistUrlData();
                if (imageUrlData2 != null && !StringUtils.isNull(imageUrlData2.imageUrl)) {
                    urlDragImageView.setAssistUrl(d(imageUrlData2.imageUrl));
                }
                String str = (String) ListUtils.getItem(this.c, pg.e(String.valueOf(urlDragImageView.getTag()), -1));
                if (imageUrlData2 != null && str != null && (imageUrlData = this.b.get(str)) != null && (imageUrlData == imageUrlData2 || Objects.equals(imageUrlData.imageUrl, imageUrlData2.imageUrl))) {
                    return super.getItemPosition(obj);
                }
            }
            if (obj instanceof FunImageView) {
                FunImageView funImageView = (FunImageView) obj;
                if (!Objects.equals(funImageView.getCurUrlTag(), ListUtils.getItem(this.c, funImageView.getCurIndex()))) {
                    return -2;
                }
                return super.getItemPosition(obj);
            } else if (obj != this.w) {
                return -2;
            } else {
                return super.getItemPosition(obj);
            }
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        List<a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, viewGroup, i)) == null) {
            View f = f(viewGroup, i);
            if (f == null && (list = this.l) != null && list.size() != 0) {
                Iterator<a> it = this.l.iterator();
                while (it.hasNext() && (f = it.next().a(viewGroup, i)) == null) {
                }
            }
            if (f == null) {
                return g(viewGroup, i);
            }
            return f;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view2, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, view2, obj)) == null) {
            return view2.equals(obj);
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (obj != null) {
                if (this.t != i || this.w != obj) {
                    b bVar = this.i;
                    if (bVar != null) {
                        bVar.a(i, obj);
                    }
                    this.t = i;
                    this.w = obj;
                }
            }
        }
    }
}
