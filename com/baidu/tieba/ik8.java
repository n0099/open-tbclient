package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.adapter.holder.ResponsePanelEmojiHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.Reaction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ik8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context a;
    public final List<Reaction> b;
    @Nullable
    public lk8 c;
    public final View.OnClickListener d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik8 a;

        public a(ik8 ik8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ik8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Reaction reaction;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (reaction = (Reaction) this.a.b.get(((Integer) view2.getTag()).intValue())) != null && this.a.c != null) {
                this.a.c.a(reaction);
            }
        }
    }

    public ik8(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.d = new a(this);
        this.a = context;
    }

    public void c(@NonNull lk8 lk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lk8Var) == null) {
            this.c = lk8Var;
        }
    }

    public void d(List<Reaction> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list.size() <= 0) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.b.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        ResponsePanelEmojiHolder responsePanelEmojiHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03e6, (ViewGroup) null);
                responsePanelEmojiHolder = new ResponsePanelEmojiHolder(view2);
                view2.setTag(responsePanelEmojiHolder);
            } else {
                responsePanelEmojiHolder = (ResponsePanelEmojiHolder) view2.getTag();
            }
            responsePanelEmojiHolder.a.startLoad(this.b.get(i).getContent());
            responsePanelEmojiHolder.a.setTag(Integer.valueOf(i));
            responsePanelEmojiHolder.a.setOnClickListener(this.d);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
