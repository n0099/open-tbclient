package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.nr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class OfficialBarFeedMsglistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public c b;
    public ArrayList<nr5> c;

    /* loaded from: classes6.dex */
    public interface c {
        void d(View view2, Object obj, int i, long j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i : invokeI.intValue;
    }

    /* loaded from: classes6.dex */
    public static class a implements nr5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;
        public int d;
        public long e;

        public void j(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            }
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.longValue;
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public long e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.e;
            }
            return invokeV.longValue;
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.a = str;
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.b = str;
            }
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                this.c = j;
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.d = i;
            }
        }

        public void k(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
                this.e = j;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public View c;
        public a d;
        public final /* synthetic */ OfficialBarFeedMsglistAdapter e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OfficialBarFeedMsglistAdapter officialBarFeedMsglistAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarFeedMsglistAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = officialBarFeedMsglistAdapter;
            this.a = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f0919fa);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0919ff);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f0919f9);
            this.a.setShowOval(true);
            this.a.setPlaceHolder(2);
            this.a.setShowOuterBorder(false);
            this.a.setShowInnerBorder(true);
            this.a.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        }

        public void a(nr5 nr5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr5Var) == null) {
                this.d = (a) nr5Var;
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
                SkinManager.setBackgroundResource(this.c, R.drawable.icon_official_bar_red_dot);
                this.a.setStrokeColorResId(R.color.CAM_X0401);
                this.a.startLoad(this.d.a(), 10, false);
                if (StringHelper.getChineseAndEnglishLength(this.d.b()) <= 10) {
                    this.b.setText(this.d.b());
                } else {
                    this.b.setText(StringHelper.cutChineseAndEnglishWithSuffix(this.d.b(), 8, "..."));
                }
                this.a.setOnClickListener(this);
                if (this.d.d() > 0 && (this.d.e() <= 0 || System.currentTimeMillis() - this.d.e() < 864000000)) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                this.c.setVisibility(8);
                if (this.e.b != null) {
                    this.e.b.d(view2, this.d, getAdapterPosition(), getItemId());
                }
            }
        }
    }

    public OfficialBarFeedMsglistAdapter(TbPageContext<?> tbPageContext, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
        this.a = tbPageContext;
        this.b = cVar;
    }

    public void m(ArrayList<? extends nr5> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || arrayList == null) {
            return;
        }
        this.c.clear();
        this.c.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList<nr5> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ArrayList<nr5> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) && (arrayList = this.c) != null && arrayList.size() > 0) {
            nr5 nr5Var = this.c.get(i);
            if ((viewHolder instanceof b) && (nr5Var instanceof a)) {
                ((b) viewHolder).a(nr5Var);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            return new b(this, this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d075a, (ViewGroup) null));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }
}
