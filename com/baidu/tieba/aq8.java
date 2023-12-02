package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
/* loaded from: classes5.dex */
public interface aq8 {
    zp8 a(Context context, RecyclerView recyclerView, int i, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO);

    zp8 b(Context context, RecyclerView recyclerView, int i);
}
