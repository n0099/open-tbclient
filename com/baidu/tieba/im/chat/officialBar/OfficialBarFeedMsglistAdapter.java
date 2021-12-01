package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public c f45863b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c.a.q0.l0.b.a> f45864c;

    /* loaded from: classes10.dex */
    public static class a implements c.a.q0.l0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f45865e;

        /* renamed from: f  reason: collision with root package name */
        public String f45866f;

        /* renamed from: g  reason: collision with root package name */
        public long f45867g;

        /* renamed from: h  reason: collision with root package name */
        public int f45868h;

        /* renamed from: i  reason: collision with root package name */
        public long f45869i;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45865e : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45866f : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45867g : invokeV.longValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45868h : invokeV.intValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45869i : invokeV.longValue;
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f45865e = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f45866f = str;
            }
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.f45867g = j2;
            }
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f45868h = i2;
            }
        }

        public void m(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            }
        }

        public void o(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
                this.f45869i = j2;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f45870e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f45871f;

        /* renamed from: g  reason: collision with root package name */
        public View f45872g;

        /* renamed from: h  reason: collision with root package name */
        public a f45873h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ OfficialBarFeedMsglistAdapter f45874i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45874i = officialBarFeedMsglistAdapter;
            this.f45870e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f45871f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f45872g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f45870e.setShowOval(true);
            this.f45870e.setPlaceHolder(2);
            this.f45870e.setShowOuterBorder(false);
            this.f45870e.setShowInnerBorder(true);
            this.f45870e.setStrokeWith(l.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(c.a.q0.l0.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f45873h = (a) aVar;
                SkinManager.setViewTextColor(this.f45871f, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f45872g, R.drawable.icon_official_bar_red_dot);
                this.f45870e.setStrokeColorResId(R.color.CAM_X0401);
                this.f45870e.startLoad(this.f45873h.a(), 10, false);
                if (StringHelper.getChineseAndEnglishLength(this.f45873h.b()) <= 10) {
                    this.f45871f.setText(this.f45873h.b());
                } else {
                    this.f45871f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f45873h.b(), 8, "..."));
                }
                this.f45870e.setOnClickListener(this);
                if (this.f45873h.d() > 0 && (this.f45873h.f() <= 0 || System.currentTimeMillis() - this.f45873h.f() < ImageLoader.f33013d)) {
                    this.f45872g.setVisibility(0);
                } else {
                    this.f45872g.setVisibility(8);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f45872g.setVisibility(8);
                if (this.f45874i.f45863b != null) {
                    this.f45874i.f45863b.a(view, this.f45873h, getAdapterPosition(), getItemId());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j2);
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45864c = new ArrayList<>();
        this.a = tbPageContext;
        this.f45863b = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<c.a.q0.l0.b.a> arrayList = this.f45864c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        ArrayList<c.a.q0.l0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f45864c) == null || arrayList.size() <= 0) {
            return;
        }
        c.a.q0.l0.b.a aVar = this.f45864c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) ? new b(this, this.a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends c.a.q0.l0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f45864c.clear();
        this.f45864c.addAll(arrayList);
        notifyDataSetChanged();
    }
}
