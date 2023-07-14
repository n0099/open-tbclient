package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.AbilityTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.AddEmojiPendantVH;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementFileItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.ElementItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.EmojiReplyPendantVH;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillIconViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.SkillTagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.tagextension.item.TagSugItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.core.BaseTagItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class go8 extends op8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public go8() {
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

    @Override // com.baidu.tieba.op8
    public BaseTagItemViewHolder b(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == ro8.b) {
                return new TagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d094c, viewGroup, false), this.a);
            }
            if (i == po8.d) {
                return new ElementItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0949, viewGroup, false), this.a);
            }
            if (i == oo8.c) {
                return new SkillTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b3, viewGroup, false), this.a);
            }
            if (i == no8.a) {
                return new SkillIconViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b2, viewGroup, false), this.a);
            }
            if (i == qo8.f) {
                return new ElementFileItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d094b, viewGroup, false), this.a);
            }
            if (i == ko8.d) {
                return new AbilityTagItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0948, viewGroup, false), this.b, this.c);
            }
            if (i == so8.b) {
                return new TagSugItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0949, viewGroup, false), this.a);
            }
            if (i == mo8.d) {
                return new EmojiReplyPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0510, viewGroup, false), this.b);
            }
            if (i == lo8.b) {
                return new AddEmojiPendantVH(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0510, viewGroup, false), this.b);
            }
            return null;
        }
        return (BaseTagItemViewHolder) invokeLI.objValue;
    }
}
