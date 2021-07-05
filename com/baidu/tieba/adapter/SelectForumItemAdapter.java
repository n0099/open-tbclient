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
import d.a.c.e.p.l;
import d.a.r0.t.j;
import d.a.s0.d;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f13754a;

    /* renamed from: b  reason: collision with root package name */
    public int f13755b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f13756c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13757d;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f13758e;

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
            this.f13758e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (jVar = (j) view.getTag()) == null) {
                return;
            }
            if (!jVar.f56715f) {
                this.f13758e.f13754a.b(jVar.f56716g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f56716g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f56710a).param("obj_source", this.f13758e.f13755b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13759a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13760b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13761c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13762d;

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
            this.f13759a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f13760b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f13761c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f13762d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
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
        this.f13757d = new a(this);
        this.f13754a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (jVar = (j) ListUtils.getItem(this.f13756c, i2)) == null) {
            return;
        }
        bVar.f13759a.setPlaceHolder(1);
        bVar.f13759a.setShowOval(true);
        bVar.f13759a.setShowOuterBorder(true);
        bVar.f13759a.setShowInnerBorder(false);
        bVar.f13759a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f13759a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f13759a.M(jVar.f56711b, 10, false);
        bVar.f13760b.setText(jVar.f56712c);
        SkinManager.setViewTextColor(bVar.f13760b, R.color.CAM_X0105);
        if (jVar.f56713d <= 0) {
            bVar.f13761c.setVisibility(8);
        } else {
            bVar.f13761c.setVisibility(0);
            SkinManager.setImageResource(bVar.f13761c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f56713d));
        }
        bVar.f13762d.setVisibility(jVar.f56714e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f13762d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f13757d);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f13756c) : invokeV.intValue;
    }

    public void h(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f13756c = list;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13755b = i2;
        }
    }
}
