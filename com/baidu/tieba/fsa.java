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
public class fsa extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<isa> a;
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

        public a(fsa fsaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fsaVar};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776085, "Lcom/baidu/tieba/fsa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776085, "Lcom/baidu/tieba/fsa;");
                return;
            }
        }
        e = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public fsa() {
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && getItem(2) != null && getItem(2).getType() == 1) {
            this.c = 0;
            this.b = getItem(2).b();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getItem(0) != null && getItem(0).getType() == 3) {
            this.c = 0;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cf4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<isa> list = this.a;
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
    public isa getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<isa> list = this.a;
            if (list == null || i < 0 || i >= list.size()) {
                return null;
            }
            return this.a.get(i);
        }
        return (isa) invokeI.objValue;
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
            isa item = getItem(i);
            if (item == null) {
                return 0;
            }
            int type = item.getType();
            if (type != 1) {
                if (type != 3) {
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
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091208);
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
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && getItem(0) != null && getItem(0).getType() == 2) {
            this.c = 0;
            this.b = ((QmFilterItem) getItem(0).c()).id;
            List<isa> list = this.a;
            if (list != null) {
                for (isa isaVar : list) {
                    QmFilterItem qmFilterItem = (QmFilterItem) isaVar.c();
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
        if ((interceptable == null || interceptable.invokeL(1048581, this, tbMusicData) == null) && getCount() > 1 && getItem(1) != null && getItem(1).getType() == 3) {
            this.c = 1;
            this.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cf2);
            notifyDataSetChanged();
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).getType() == 3 && (getItem(1).c() instanceof MusicData)) {
            ((MusicData) getItem(1).c()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        View view3;
        isa isaVar;
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
                            view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0198, (ViewGroup) null);
                            b(aVar, view3, viewGroup);
                            aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                        }
                    } else {
                        view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0199, (ViewGroup) null);
                        b(aVar, view3, viewGroup);
                        aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f091217);
                        aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f08036c);
                        aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                    }
                } else {
                    view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0199, (ViewGroup) null);
                    b(aVar, view3, viewGroup);
                    aVar.b = (ProgressBar) view3.findViewById(R.id.obfuscated_res_0x7f091217);
                    aVar.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view3.setTag(aVar);
            } else {
                aVar = (a) view2.getTag();
                view3 = view2;
            }
            List<isa> list = this.a;
            if (list != null && i >= 0 && i <= list.size() - 1 && (isaVar = this.a.get(i)) != null) {
                int itemViewType2 = getItemViewType(i);
                if (itemViewType2 != 0) {
                    if (itemViewType2 != 1) {
                        if (itemViewType2 == 2) {
                            if (!TextUtils.isEmpty(isaVar.b()) && isaVar.b().equals(this.b)) {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802aa);
                            } else {
                                aVar.a.setBackgroundResource(R.drawable.obfuscated_res_0x7f0802a9);
                            }
                            aVar.c.setText(isaVar.b());
                        }
                    } else {
                        MusicData musicData = (MusicData) isaVar.c();
                        int i2 = musicData.editMusicType;
                        if (i2 != 0 && (i2 != 2 || TextUtils.isEmpty(musicData.img))) {
                            TbImageView tbImageView = aVar.a;
                            String valueOf = String.valueOf(isaVar.a());
                            int i3 = e;
                            tbImageView.startLoad(valueOf, 24, i3, i3, false);
                        } else {
                            TbImageView tbImageView2 = aVar.a;
                            String str = musicData.img;
                            int i4 = e;
                            tbImageView2.startLoad(str, 10, i4, i4, false);
                        }
                        if (!TextUtils.isEmpty(isaVar.b()) && isaVar.b().equals(this.b)) {
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
                    QmFilterItem qmFilterItem = (QmFilterItem) isaVar.c();
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
                    aVar.c.setText(isaVar.b());
                }
                aVar.a.setTag(isaVar);
                aVar.a.setTag(R.id.obfuscated_res_0x7f091e80, aVar);
                aVar.a.setOnClickListener(this);
                aVar.d = i;
            }
            return view3;
        }
        return (View) invokeILL.objValue;
    }

    public void h(List<isa> list, String str) {
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
        if ((interceptable == null || interceptable.invokeL(1048592, this, view2) == null) && view2.getId() == R.id.obfuscated_res_0x7f091208 && (view2.getTag() instanceof isa)) {
            isa isaVar = (isa) view2.getTag();
            if (isaVar.getType() == 3 && (isaVar.c() instanceof MusicData)) {
                if (view2.getResources().getString(R.string.obfuscated_res_0x7f0f0cf2).equals(isaVar.b()) && (iVar = this.d) != null) {
                    iVar.b(isaVar, view2.getTag(R.id.obfuscated_res_0x7f091e80));
                    this.c = this.a.indexOf(isaVar);
                    this.b = isaVar.b();
                }
                if (!TextUtils.isEmpty(isaVar.b()) && isaVar.b().equals(this.b)) {
                    return;
                }
                if (!isaVar.b().equals(view2.getResources().getString(R.string.obfuscated_res_0x7f0f0cf2))) {
                    this.c = this.a.indexOf(isaVar);
                }
            } else {
                this.c = this.a.indexOf(isaVar);
            }
            if (isaVar.getType() == 2 && (isaVar.c() instanceof QmFilterItem)) {
                this.b = ((QmFilterItem) isaVar.c()).id;
            } else {
                this.b = isaVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.d;
            if (iVar2 != null) {
                iVar2.b(isaVar, view2.getTag(R.id.obfuscated_res_0x7f091e80));
            }
        }
    }
}
