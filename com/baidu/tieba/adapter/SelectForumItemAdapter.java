package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.q0.u.i;
import c.a.r0.f;
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
/* loaded from: classes7.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f49249a;

    /* renamed from: b  reason: collision with root package name */
    public int f49250b;

    /* renamed from: c  reason: collision with root package name */
    public List<i> f49251c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnClickListener f49252d;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SelectForumItemAdapter f49253e;

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
            this.f49253e = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (iVar = (i) view.getTag()) == null) {
                return;
            }
            if (!iVar.f15064f) {
                this.f49253e.f49249a.showTip(iVar.f15065g);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, iVar.f15065g));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", iVar.f15059a).param("obj_source", this.f49253e.f49250b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, iVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f49254a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f49255b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f49256c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f49257d;

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
            this.f49254a = (BarImageView) view.findViewById(R.id.cell_select_forum_img);
            this.f49255b = (TextView) view.findViewById(R.id.cell_select_forum_name);
            this.f49256c = (ImageView) view.findViewById(R.id.cell_select_forum_level);
            this.f49257d = (TextView) view.findViewById(R.id.cell_select_forum_lately);
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
        this.f49252d = new a(this);
        this.f49249a = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f49251c) : invokeV.intValue;
    }

    public void setDataList(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f49251c = list;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f49250b = i2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bVar, i2) == null) || (iVar = (i) ListUtils.getItem(this.f49251c, i2)) == null) {
            return;
        }
        bVar.f49254a.setPlaceHolder(1);
        bVar.f49254a.setShowOval(true);
        bVar.f49254a.setShowOuterBorder(true);
        bVar.f49254a.setShowInnerBorder(false);
        bVar.f49254a.setStrokeColorResId(R.color.CAM_X0401);
        bVar.f49254a.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        bVar.f49254a.startLoad(iVar.f15060b, 10, false);
        bVar.f49255b.setText(iVar.f15061c);
        SkinManager.setViewTextColor(bVar.f49255b, R.color.CAM_X0105);
        if (iVar.f15062d <= 0) {
            bVar.f49256c.setVisibility(8);
        } else {
            bVar.f49256c.setVisibility(0);
            SkinManager.setImageResource(bVar.f49256c, BitmapHelper.getGradeResourceIdInEnterForum(iVar.f15062d));
        }
        bVar.f49257d.setVisibility(iVar.f15063e ? 0 : 8);
        SkinManager.setViewTextColor(bVar.f49257d, R.color.CAM_X0302);
        bVar.itemView.setTag(iVar);
        SkinManager.setBackgroundResource(bVar.itemView, R.drawable.forum_selected_view_bg);
        bVar.itemView.setOnClickListener(this.f49252d);
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
