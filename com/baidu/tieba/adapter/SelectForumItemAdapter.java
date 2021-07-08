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
import d.a.o0.t.j;
import d.a.p0.d;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f13793a;

    /* renamed from: b  reason: collision with root package name */
    public int f13794b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f13795c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f13796d;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f13797e;

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
            this.f13797e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (jVar = (j) view.getTag()) == null) {
                return;
            }
            if (!jVar.f53434f) {
                this.f13797e.f13793a.b(jVar.f53435g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f53435g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f53429a).param("obj_source", this.f13797e.f13794b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes3.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f13798a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f13799b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f13800c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f13801d;

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
            this.f13798a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f13799b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f13800c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f13801d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
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
        this.f13796d = new a(this);
        this.f13793a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, bVar, i2) == null) || (jVar = (j) ListUtils.getItem(this.f13795c, i2)) == null) {
            return;
        }
        bVar.f13798a.setPlaceHolder(1);
        bVar.f13798a.setShowOval(true);
        bVar.f13798a.setShowOuterBorder(true);
        bVar.f13798a.setShowInnerBorder(false);
        bVar.f13798a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f13798a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f13798a.M(jVar.f53430b, 10, false);
        bVar.f13799b.setText(jVar.f53431c);
        SkinManager.setViewTextColor(bVar.f13799b, R.color.CAM_X0105);
        if (jVar.f53432d <= 0) {
            bVar.f13800c.setVisibility(8);
        } else {
            bVar.f13800c.setVisibility(0);
            SkinManager.setImageResource(bVar.f13800c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f53432d));
        }
        bVar.f13801d.setVisibility(jVar.f53433e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f13801d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f13796d);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ListUtils.getCount(this.f13795c) : invokeV.intValue;
    }

    public void h(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f13795c = list;
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13794b = i2;
        }
    }
}
