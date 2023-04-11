package com.baidu.tieba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.R;
import com.baidu.tieba.fy5;
import com.baidu.tieba.ii;
import com.baidu.tieba.ww5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class SelectForumItemAdapter extends RecyclerView.Adapter<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ww5 a;
    public int b;
    public List<SelectForumData> c;
    public View.OnClickListener d;
    public View.OnClickListener e;
    @Nullable
    public fy5.e f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumItemAdapter a;

        public a(SelectForumItemAdapter selectForumItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (selectForumData = (SelectForumData) view2.getTag()) == null) {
                return;
            }
            if (!selectForumData.isCanPost) {
                this.a.a.b(selectForumData.blockInfo);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921507, selectForumData.blockInfo));
                return;
            }
            TiebaStatic.log(new StatisticItem("c13995").param("fid", selectForumData.forumId).param("obj_source", this.a.b));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921505, selectForumData));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921503));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumItemAdapter a;

        public b(SelectForumItemAdapter selectForumItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumItemAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SelectForumData selectForumData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (selectForumData = (SelectForumData) view2.getTag()) != null && this.a.f != null) {
                this.a.f.a(selectForumData);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public ImageView c;
        public TextView d;
        public ImageView e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SelectForumItemAdapter selectForumItemAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumItemAdapter, view2};
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
            this.a = (BarImageView) view2.findViewById(R.id.obfuscated_res_0x7f090641);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090644);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090643);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090642);
            this.e = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090645);
        }
    }

    public SelectForumItemAdapter(ww5 ww5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ww5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.e = new b(this);
        this.a = ww5Var;
    }

    public void p(List<SelectForumData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.c = list;
        }
    }

    public void q(fy5.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f = eVar;
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b = i;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.c);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(@NonNull c cVar, int i) {
        SelectForumData selectForumData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, i) != null) || (selectForumData = (SelectForumData) ListUtils.getItem(this.c, i)) == null) {
            return;
        }
        cVar.a.setPlaceHolder(1);
        cVar.a.setShowOval(true);
        cVar.a.setShowOuterBorder(true);
        int i2 = 0;
        cVar.a.setShowInnerBorder(false);
        cVar.a.setStrokeColorResId(R.color.CAM_X0401);
        cVar.a.setStrokeWith(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        cVar.a.N(selectForumData.avatarUrl, 10, false);
        cVar.b.setText(selectForumData.forumName);
        SkinManager.setViewTextColor(cVar.b, (int) R.color.CAM_X0105);
        if (selectForumData.level <= 0) {
            cVar.c.setVisibility(8);
        } else {
            cVar.c.setVisibility(0);
            SkinManager.setImageResource(cVar.c, BitmapHelper.getGradeResourceIdInEnterForum(selectForumData.level));
        }
        if (this.f != null) {
            cVar.d.setVisibility(8);
            cVar.e.setVisibility(0);
            if (selectForumData.isInterestForumSelected) {
                WebPManager.setPureDrawable(cVar.e, R.drawable.icon_pure_strok324_select, R.color.CAM_X0302, WebPManager.ResourceStateType.NORMAL);
            } else {
                WebPManager.setPureDrawable(cVar.e, R.drawable.icon_pure_strok324, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL);
            }
        } else {
            TextView textView = cVar.d;
            if (!selectForumData.isLately) {
                i2 = 8;
            }
            textView.setVisibility(i2);
            cVar.e.setVisibility(8);
        }
        SkinManager.setViewTextColor(cVar.d, (int) R.color.CAM_X0302);
        cVar.itemView.setTag(selectForumData);
        SkinManager.setBackgroundResource(cVar.itemView, R.drawable.forum_selected_view_bg);
        if (this.f != null) {
            selectForumData.index = i;
            cVar.itemView.setOnClickListener(this.e);
            return;
        }
        cVar.itemView.setOnClickListener(this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: o */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
            return new c(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01df, viewGroup, false));
        }
        return (c) invokeLI.objValue;
    }
}
