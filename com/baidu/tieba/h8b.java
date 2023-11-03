package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class h8b extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<k8b> a;
    public String b;
    public int c;
    public RecordEffectLayout.i d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public ProgressBar b;
        public TextView c;
        public int d;

        public a(h8b h8bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h8bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778999, "Lcom/baidu/tieba/h8b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778999, "Lcom/baidu/tieba/h8b;");
                return;
            }
        }
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public h8b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(2) != null && getItem(2).c() == 1) {
            this.c = 0;
            this.b = getItem(2).b();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getItem(0) != null && getItem(0).c() == 3) {
            this.c = 0;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d34);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<k8b> list = this.a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public k8b getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<k8b> list = this.a;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (k8b) invokeI.objValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            k8b item = getItem(i);
            if (item == null) {
                return 0;
            }
            int c = item.c();
            if (c != 1) {
                if (c != 3) {
                    return 0;
                }
                return 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public void i(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, iVar) == null) {
            this.d = iVar;
        }
    }

    public final void b(a aVar, View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, view2, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f09126a);
            aVar.a = tbImageView;
            tbImageView.setIsRound(true);
            aVar.a.setDrawerType(1);
            aVar.a.setDefaultBgResource(R.color.transparent);
            aVar.a.setBorderWidth(BdUtilHelper.getDimens(viewGroup.getContext(), R.dimen.obfuscated_res_0x7f070224));
            aVar.a.setConrers(15);
            aVar.a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            aVar.c = (TextView) view2.findViewById(R.id.tv_name);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).c() == 2) {
            this.c = 0;
            this.b = ((QmFilterItem) getItem(0).d()).id;
            List<k8b> list = this.a;
            if (list != null) {
                for (k8b k8bVar : list) {
                    QmFilterItem qmFilterItem = (QmFilterItem) k8bVar.d();
                    if ("-1".equals(qmFilterItem.id)) {
                        qmFilterItem.isSelect = true;
                    } else {
                        qmFilterItem.isSelect = false;
                        qmFilterItem.isDownLoading = false;
                    }
                }
            }
        }
    }

    public void f(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) && getCount() > 1 && getItem(1) != null && getItem(1).c() == 3) {
            this.c = 1;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d32);
            notifyDataSetChanged();
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).c() == 3 && (getItem(1).d() instanceof MusicData)) {
            ((MusicData) getItem(1).d()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        View view3;
        k8b k8bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                aVar = new a(this);
                int itemViewType = getItemViewType(i);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            view3 = view2;
                        } else {
                            view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01a0, (ViewGroup) null);
                            b(aVar, view3, viewGroup);
                            aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                        }
                    } else {
                        view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01a1, (ViewGroup) null);
                        b(aVar, view3, viewGroup);
                        aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f091278);
                        aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f08037a);
                        aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                    }
                } else {
                    view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01a1, (ViewGroup) null);
                    b(aVar, view3, viewGroup);
                    aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f091278);
                    aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view3.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
                view3 = view2;
            }
            List<k8b> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (k8bVar = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 != 0) {
                    if (itemViewType2 != 1) {
                        if (itemViewType2 == 2) {
                            if (!TextUtils.isEmpty(k8bVar.b()) && k8bVar.b().equals(this.b)) {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802b6);
                            } else {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802b5);
                            }
                            aVar.c.setText(k8bVar.b());
                        }
                    } else {
                        MusicData musicData = (MusicData) k8bVar.d();
                        int i2 = musicData.editMusicType;
                        if (i2 != 0 && (i2 != 2 || TextUtils.isEmpty(musicData.img))) {
                            TbImageView tbImageView = aVar.a;
                            String valueOf = String.valueOf(k8bVar.a());
                            int i3 = e;
                            tbImageView.startLoad(valueOf, 24, i3, i3, false);
                        } else {
                            TbImageView tbImageView2 = aVar.a;
                            String str = musicData.img;
                            int i4 = e;
                            tbImageView2.startLoad(str, 10, i4, i4, false);
                        }
                        if (!TextUtils.isEmpty(k8bVar.b()) && k8bVar.b().equals(this.b)) {
                            aVar.a.setDrawBorder(true);
                        } else {
                            aVar.a.setDrawBorder(false);
                        }
                        if (this.c != i) {
                            aVar.b.setVisibility(4);
                        } else if (aVar.b.getVisibility() == 0) {
                            aVar.a.setDrawBorder(false);
                        }
                        aVar.c.setText(musicData.name);
                    }
                } else {
                    QmFilterItem qmFilterItem = (QmFilterItem) k8bVar.d();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView3 = aVar.a;
                        String str2 = qmFilterItem.bgurl;
                        int i5 = e;
                        tbImageView3.startLoad(str2, 24, i5, i5, false);
                    } else {
                        TbImageView tbImageView4 = aVar.a;
                        String str3 = qmFilterItem.bgurl;
                        int i6 = e;
                        tbImageView4.startLoad(str3, 10, i6, i6, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.b)) {
                        aVar.a.setDrawBorder(true);
                    } else {
                        aVar.a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        aVar.b.setVisibility(0);
                    } else {
                        aVar.b.setVisibility(4);
                    }
                    if (this.c != i) {
                        aVar.b.setVisibility(4);
                    } else if (aVar.b.getVisibility() == 0) {
                        aVar.a.setDrawBorder(false);
                    }
                    aVar.c.setText(k8bVar.b());
                }
                aVar.a.setTag(k8bVar);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091eff, aVar);
                aVar.a.setOnClickListener(this);
                aVar.d = i;
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<k8b> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f09126a && (view2.getTag() instanceof k8b)) {
            k8b k8bVar = (k8b) view2.getTag();
            if (k8bVar.c() == 3 && (k8bVar.d() instanceof MusicData)) {
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0d32).equals(k8bVar.b()) && (iVar = this.d) != null) {
                    iVar.b(k8bVar, view2.getTag(R.id.obfuscated_res_0x7f091eff));
                    this.c = this.a.indexOf(k8bVar);
                    this.b = k8bVar.b();
                }
                if (!TextUtils.isEmpty(k8bVar.b()) && k8bVar.b().equals(this.b)) {
                    return;
                }
                if (!k8bVar.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0d32))) {
                    this.c = this.a.indexOf(k8bVar);
                }
            } else {
                this.c = this.a.indexOf(k8bVar);
            }
            if (k8bVar.c() == 2 && (k8bVar.d() instanceof QmFilterItem)) {
                this.b = ((QmFilterItem) k8bVar.d()).id;
            } else {
                this.b = k8bVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.d;
            if (iVar2 != null) {
                iVar2.b(k8bVar, view2.getTag(R.id.obfuscated_res_0x7f091eff));
            }
        }
    }
}
