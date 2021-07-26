package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.u.i;
import d.a.q0.d;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f13841a;

    /* renamed from: b  reason: collision with root package name */
    public int f13842b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f13843c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13844d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f13845e;

        public a(SelectForumItemAdapter selectForumItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13845e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (iVar = (i) view.getTag()) == null) {
                return;
            }
            if (!iVar.f54107f) {
                this.f13845e.f13841a.b(iVar.f54108g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, iVar.f54108g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", iVar.f54102a).param("obj_source", this.f13845e.f13842b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, iVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13846a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13847b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13848c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13849d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SelectForumItemAdapter selectForumItemAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumItemAdapter, view};
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
            this.f13846a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f13847b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f13848c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f13849d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13844d = new a(this);
        this.f13841a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (iVar = (i) ListUtils.getItem(this.f13843c, i2)) == null) {
            return;
        }
        bVar.f13846a.setPlaceHolder(1);
        bVar.f13846a.setShowOval(true);
        bVar.f13846a.setShowOuterBorder(true);
        bVar.f13846a.setShowInnerBorder(false);
        bVar.f13846a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f13846a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f13846a.M(iVar.f54103b, 10, false);
        bVar.f13847b.setText(iVar.f54104c);
        SkinManager.setViewTextColor(bVar.f13847b, R.color.CAM_X0105);
        if (iVar.f54105d <= 0) {
            bVar.f13848c.setVisibility(8);
        } else {
            bVar.f13848c.setVisibility(0);
            SkinManager.setImageResource(bVar.f13848c, BitmapHelper.getGradeResourceIdInEnterForum(iVar.f54105d));
        }
        bVar.f13849d.setVisibility(iVar.f54106e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f13849d, R.color.CAM_X0302);
        bVar.itemView.setTag(iVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f13844d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: g */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) ? new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false)) : (b) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f13843c) : invokeV.intValue;
    }

    public void h(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f13843c = list;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13842b = i2;
        }
    }
}
