package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.f.p.l;
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
/* loaded from: classes9.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f51164a;

    /* renamed from: b  reason: collision with root package name */
    public c f51165b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b.a.q0.k0.b.a> f51166c;

    /* loaded from: classes9.dex */
    public static class a implements b.a.q0.k0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f51167e;

        /* renamed from: f  reason: collision with root package name */
        public String f51168f;

        /* renamed from: g  reason: collision with root package name */
        public long f51169g;

        /* renamed from: h  reason: collision with root package name */
        public int f51170h;

        /* renamed from: i  reason: collision with root package name */
        public long f51171i;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51167e : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51168f : (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51169g : invokeV.longValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f51170h : invokeV.intValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51171i : invokeV.longValue;
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f51167e = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f51168f = str;
            }
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.f51169g = j;
            }
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f51170h = i2;
            }
        }

        public void m(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            }
        }

        public void o(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                this.f51171i = j;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f51172e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f51173f;

        /* renamed from: g  reason: collision with root package name */
        public View f51174g;

        /* renamed from: h  reason: collision with root package name */
        public a f51175h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ OfficialBarFeedMsglistAdapter f51176i;

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
            this.f51176i = officialBarFeedMsglistAdapter;
            this.f51172e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f51173f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f51174g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f51172e.setShowOval(true);
            this.f51172e.setPlaceHolder(2);
            this.f51172e.setShowOuterBorder(false);
            this.f51172e.setShowInnerBorder(true);
            this.f51172e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(b.a.q0.k0.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f51175h = (a) aVar;
                SkinManager.setViewTextColor(this.f51173f, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f51174g, R.drawable.icon_official_bar_red_dot);
                this.f51172e.setStrokeColorResId(R.color.CAM_X0401);
                this.f51172e.startLoad(this.f51175h.a(), 10, false);
                if (StringHelper.getChineseAndEnglishLength(this.f51175h.b()) <= 10) {
                    this.f51173f.setText(this.f51175h.b());
                } else {
                    this.f51173f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f51175h.b(), 8, "..."));
                }
                this.f51172e.setOnClickListener(this);
                if (this.f51175h.d() > 0 && (this.f51175h.f() <= 0 || System.currentTimeMillis() - this.f51175h.f() < ImageLoader.f36842d)) {
                    this.f51174g.setVisibility(0);
                } else {
                    this.f51174g.setVisibility(8);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f51174g.setVisibility(8);
                if (this.f51176i.f51165b != null) {
                    this.f51176i.f51165b.a(view, this.f51175h, getAdapterPosition(), getItemId());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(View view, Object obj, int i2, long j);
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
        this.f51166c = new ArrayList<>();
        this.f51164a = tbPageContext;
        this.f51165b = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<b.a.q0.k0.b.a> arrayList = this.f51166c;
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
        ArrayList<b.a.q0.k0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f51166c) == null || arrayList.size() <= 0) {
            return;
        }
        b.a.q0.k0.b.a aVar = this.f51166c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) ? new b(this, this.f51164a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends b.a.q0.k0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f51166c.clear();
        this.f51166c.addAll(arrayList);
        notifyDataSetChanged();
    }
}
