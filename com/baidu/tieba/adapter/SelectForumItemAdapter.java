package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.a.e.e.p.l;
import b.a.q0.u.j;
import b.a.r0.f;
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
import java.util.List;
/* loaded from: classes9.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f46717a;

    /* renamed from: b  reason: collision with root package name */
    public int f46718b;

    /* renamed from: c  reason: collision with root package name */
    public List<j> f46719c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f46720d;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f46721e;

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
            this.f46721e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (jVar = (j) view.getTag()) == null) {
                return;
            }
            if (!jVar.f14146f) {
                this.f46721e.f46717a.showTip(jVar.f14147g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, jVar.f14147g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", jVar.f14141a).param("obj_source", this.f46721e.f46718b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, jVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f46722a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f46723b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f46724c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f46725d;

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
            this.f46722a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f46723b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f46724c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f46725d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
        }
    }

    public SelectForumItemAdapter(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46720d = new a(this);
        this.f46717a = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f46719c) : invokeV.intValue;
    }

    public void setDataList(List<j> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f46719c = list;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f46718b = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || (jVar = (j) ListUtils.getItem(this.f46719c, i2)) == null) {
            return;
        }
        bVar.f46722a.setPlaceHolder(1);
        bVar.f46722a.setShowOval(true);
        bVar.f46722a.setShowOuterBorder(true);
        bVar.f46722a.setShowInnerBorder(false);
        bVar.f46722a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f46722a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f46722a.startLoad(jVar.f14142b, 10, false);
        bVar.f46723b.setText(jVar.f14143c);
        SkinManager.setViewTextColor(bVar.f46723b, R.color.CAM_X0105);
        if (jVar.f14144d <= 0) {
            bVar.f46724c.setVisibility(8);
        } else {
            bVar.f46724c.setVisibility(0);
            SkinManager.setImageResource(bVar.f46724c, BitmapHelper.getGradeResourceIdInEnterForum(jVar.f14144d));
        }
        bVar.f46725d.setVisibility(jVar.f14145e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f46725d, R.color.CAM_X0302);
        bVar.itemView.setTag(jVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f46720d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false)) : (b) invokeLI.objValue;
    }
}
