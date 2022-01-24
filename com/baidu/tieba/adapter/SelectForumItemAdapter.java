package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.t0.g;
import c.a.t0.q;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes12.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;

    /* renamed from: b  reason: collision with root package name */
    public int f41775b;

    /* renamed from: c  reason: collision with root package name */
    public List<SelectForumData> f41776c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f41777d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f41778e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public q.e f41779f;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f41780e;

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
            this.f41780e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (selectForumData = (SelectForumData) view.getTag()) == null) {
                return;
            }
            if (!selectForumData.isCanPost) {
                this.f41780e.a.showTip(selectForumData.blockInfo);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, selectForumData.blockInfo));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", selectForumData.forumId).param("obj_source", this.f41780e.f41775b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, selectForumData));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f41781e;

        public b(SelectForumItemAdapter selectForumItemAdapter) {
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
            this.f41781e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (selectForumData = (SelectForumData) view.getTag()) == null || this.f41781e.f41779f == null) {
                return;
            }
            this.f41781e.f41779f.a(selectForumData);
        }
    }

    /* loaded from: classes12.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f41782b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f41783c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f41784d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f41785e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SelectForumItemAdapter selectForumItemAdapter, View view) {
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
            this.a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f41782b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f41783c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f41784d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
            this.f41785e = (ImageView) view.findViewById(R.id.cell_select_interest_forum_iv);
        }
    }

    public SelectForumItemAdapter(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41777d = new a(this);
        this.f41778e = new b(this);
        this.a = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f41776c) : invokeV.intValue;
    }

    public void setDataList(List<SelectForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f41776c = list;
        }
    }

    public void setForumSelectStateChangedListener(q.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f41779f = eVar;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f41775b = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull c cVar, int i2) {
        SelectForumData selectForumData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) || (selectForumData = (SelectForumData) ListUtils.getItem(this.f41776c, i2)) == null) {
            return;
        }
        cVar.a.setPlaceHolder(1);
        cVar.a.setShowOval(true);
        cVar.a.setShowOuterBorder(true);
        cVar.a.setShowInnerBorder(false);
        cVar.a.setStrokeColorResId(R.color.CAM_X0401);
        cVar.a.setStrokeWith(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        cVar.a.startLoad(selectForumData.avatarUrl, 10, false);
        cVar.f41782b.setText(selectForumData.forumName);
        SkinManager.setViewTextColor(cVar.f41782b, R.color.CAM_X0105);
        if (selectForumData.level <= 0) {
            cVar.f41783c.setVisibility(8);
        } else {
            cVar.f41783c.setVisibility(0);
            SkinManager.setImageResource(cVar.f41783c, BitmapHelper.getGradeResourceIdInEnterForum(selectForumData.level));
        }
        if (this.f41779f != null) {
            cVar.f41784d.setVisibility(8);
            cVar.f41785e.setVisibility(0);
            if (selectForumData.isInterestForumSelected) {
                WebPManager.setPureDrawable(cVar.f41785e, R.drawable.icon_pure_strok324_select, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.setPureDrawable(cVar.f41785e, R.drawable.icon_pure_strok324, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
            }
        } else {
            cVar.f41784d.setVisibility(selectForumData.isLately ? 0 : 8);
            cVar.f41785e.setVisibility(8);
        }
        SkinManager.setViewTextColor(cVar.f41784d, R.color.CAM_X0302);
        cVar.itemView.setTag(selectForumData);
        SkinManager.setBackgroundResource(cVar.itemView, R.drawable.forum_selected_view_bg);
        if (this.f41779f != null) {
            selectForumData.index = i2;
            cVar.itemView.setOnClickListener(this.f41778e);
            return;
        }
        cVar.itemView.setOnClickListener(this.f41777d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) ? new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_select_forum_layout, viewGroup, false)) : (c) invokeLI.objValue;
    }
}
