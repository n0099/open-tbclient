package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
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
/* loaded from: classes7.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f52799a;

    /* renamed from: b  reason: collision with root package name */
    public c f52800b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<c.a.p0.i0.b.a> f52801c;

    /* loaded from: classes7.dex */
    public static class a implements c.a.p0.i0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f52802e;

        /* renamed from: f  reason: collision with root package name */
        public String f52803f;

        /* renamed from: g  reason: collision with root package name */
        public long f52804g;

        /* renamed from: h  reason: collision with root package name */
        public int f52805h;

        /* renamed from: i  reason: collision with root package name */
        public long f52806i;

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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52802e : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52803f : (String) invokeV.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52804g : invokeV.longValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52805h : invokeV.intValue;
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52806i : invokeV.longValue;
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f52802e = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f52803f = str;
            }
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.f52804g = j2;
            }
        }

        public void k(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.f52805h = i2;
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
                this.f52806i = j2;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public BarImageView f52807e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f52808f;

        /* renamed from: g  reason: collision with root package name */
        public View f52809g;

        /* renamed from: h  reason: collision with root package name */
        public a f52810h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ OfficialBarFeedMsglistAdapter f52811i;

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
            this.f52811i = officialBarFeedMsglistAdapter;
            this.f52807e = (BarImageView) view.findViewById(R.id.official_bar_image);
            this.f52808f = (TextView) view.findViewById(R.id.official_bar_name);
            this.f52809g = view.findViewById(R.id.official_bar_feed_red_dot);
            this.f52807e.setShowOval(true);
            this.f52807e.setPlaceHolder(2);
            this.f52807e.setShowOuterBorder(false);
            this.f52807e.setShowInnerBorder(true);
            this.f52807e.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(c.a.p0.i0.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f52810h = (a) aVar;
                SkinManager.setViewTextColor(this.f52808f, R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.f52809g, R.drawable.icon_official_bar_red_dot);
                this.f52807e.setStrokeColorResId(R.color.CAM_X0401);
                this.f52807e.startLoad(this.f52810h.a(), 10, false);
                if (StringHelper.getChineseAndEnglishLength(this.f52810h.b()) <= 10) {
                    this.f52808f.setText(this.f52810h.b());
                } else {
                    this.f52808f.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.f52810h.b(), 8, "..."));
                }
                this.f52807e.setOnClickListener(this);
                if (this.f52810h.e() > 0 && (this.f52810h.f() <= 0 || System.currentTimeMillis() - this.f52810h.f() < ImageLoader.f37824d)) {
                    this.f52809g.setVisibility(0);
                } else {
                    this.f52809g.setVisibility(8);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                this.f52809g.setVisibility(8);
                if (this.f52811i.f52800b != null) {
                    this.f52811i.f52800b.a(view, this.f52810h, getAdapterPosition(), getItemId());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f52801c = new ArrayList<>();
        this.f52799a = tbPageContext;
        this.f52800b = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<c.a.p0.i0.b.a> arrayList = this.f52801c;
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
        ArrayList<c.a.p0.i0.b.a> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) || (arrayList = this.f52801c) == null || arrayList.size() <= 0) {
            return;
        }
        c.a.p0.i0.b.a aVar = this.f52801c.get(i2);
        if ((viewHolder instanceof b) && (aVar instanceof a)) {
            ((b) viewHolder).a(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) ? new b(this, this.f52799a.getPageActivity().getLayoutInflater().inflate(R.layout.official_bar_feed_header_item, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(ArrayList<? extends c.a.p0.i0.b.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f52801c.clear();
        this.f52801c.addAll(arrayList);
        notifyDataSetChanged();
    }
}
