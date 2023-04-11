package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.afx.TbAlphaVideo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.dl9;
import com.baidu.tieba.write.view.xrichtext.RichImageItem;
import com.baidu.tieba.write.view.xrichtext.RichTextEditor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class f4a extends t3a<f5a> implements n4a, o4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RichTextEditor t;
    @Nullable
    public m4a u;
    @NonNull
    public final b6a v;
    public final RichImageItem.f w;

    @Override // com.baidu.tieba.r4a
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements RichImageItem.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4a a;

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void b(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, view2) == null) {
            }
        }

        public a(f4a f4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4aVar;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichImageItem.f
        public void a(ImageFileInfo imageFileInfo, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, imageFileInfo, view2) != null) || this.a.b == null) {
                return;
            }
            if (ListUtils.isEmpty(this.a.v.g().getChosedFiles())) {
                this.a.b.i();
            }
            this.a.b.x(new int[]{10, 34});
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RichTextEditor.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f4a a;

        public b(f4a f4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f4aVar;
        }

        @Override // com.baidu.tieba.write.view.xrichtext.RichTextEditor.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a.showToast(R.string.over_limit_tip);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f4a(TbPageContext<?> tbPageContext, @NonNull b6a b6aVar, @NonNull f3a f3aVar, @NonNull x5a x5aVar) {
        super(tbPageContext, f5a.class, f3aVar, x5aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, b6aVar, f3aVar, x5aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1], (f3a) objArr2[2], (x5a) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = new a(this);
        this.v = b6aVar;
        b6aVar.c(this);
    }

    @Override // com.baidu.tieba.t3a
    public void L(Editable editable) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            super.L(editable);
            WriteData writeData = this.e;
            if (writeData != null && (richTextEditor = this.t) != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.t3a
    public void O(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.i(arrayList);
    }

    @Override // com.baidu.tieba.t3a
    public void P(ArrayList<AtSelectData> arrayList) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, arrayList) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        richTextEditor.m(arrayList);
    }

    public void a0(m4a m4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, m4aVar) == null) {
            this.u = m4aVar;
        }
    }

    @Override // com.baidu.tieba.r4a
    public void b(boolean z) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && !z && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().clearFocus();
        }
    }

    public final void b0(ImageFileInfo imageFileInfo) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, imageFileInfo) == null) && (richTextEditor = this.t) != null && this.e != null) {
            richTextEditor.u(imageFileInfo);
            this.e.setRichContentData(this.t.getPlainTextContentData());
        }
    }

    public void c0(dl9.f fVar) {
        u5a u5aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) && (u5aVar = this.l) != null) {
            u5aVar.p(fVar);
        }
    }

    @Override // com.baidu.tieba.q4a
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, writeData) == null) {
            writeData.setRichTextEditorMode(true);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                writeData.setRichContentData(richTextEditor.getPlainTextContentData());
            }
        }
    }

    @Override // com.baidu.tieba.o4a
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.o4a
    public void k(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            d0(str);
        }
    }

    @Override // com.baidu.tieba.t3a, com.baidu.tieba.q4a
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            super.onChangeSkinType(i);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.x();
            }
        }
    }

    @Override // com.baidu.tieba.t3a, com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.v.o(bundle);
        }
    }

    @Override // com.baidu.tieba.n4a
    public void onUpdate(Object obj) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, obj) == null) && (obj instanceof SelectForumData) && (richTextEditor = this.t) != null) {
            richTextEditor.setForumId(gg.g(((SelectForumData) obj).forumId, 0L));
        }
    }

    @Override // com.baidu.tieba.o4a
    public void u(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            e0(str);
        }
    }

    @Override // com.baidu.tieba.o4a
    public void v(String str) {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0) {
            e0(str);
        }
    }

    @Override // com.baidu.tieba.t3a
    public void N(e85 e85Var) {
        RichTextEditor richTextEditor;
        ImageFileInfo b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e85Var) == null) && this.b != null && (richTextEditor = this.t) != null && richTextEditor.getVisibility() == 0 && (b2 = this.v.b(this.b, e85Var)) != null) {
            b0(b2);
            this.b.i();
            this.b.x(new int[]{10, 34});
        }
    }

    @Override // com.baidu.tieba.q4a
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, writeData) == null) {
            this.v.d(writeData);
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                this.t.setWriteImagesInfo(this.v.g());
                writeData.setRichContentData(this.t.getPostServerContentData());
                writeData.setServerRichContent(this.t.getPostServerContentData());
                writeData.setRichTextEditorMode(true);
            }
        }
    }

    @Override // com.baidu.tieba.t3a
    @Nullable
    public ArrayList<AtSelectData> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getAtDataInText();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t3a
    @Nullable
    public EditText S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && richTextEditor.getVisibility() == 0) {
                return this.t.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.d();
            this.v.q(this);
        }
    }

    @Override // com.baidu.tieba.r4a
    public void l() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (richTextEditor = this.t) != null && richTextEditor.getLastFocusEdit() != null) {
            this.t.getLastFocusEdit().requestFocus();
        }
    }

    @Override // com.baidu.tieba.r4a
    public void n() {
        RichTextEditor richTextEditor;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (richTextEditor = this.t) == null) {
            return;
        }
        this.n.f(richTextEditor.getLastFocusEdit(), false);
    }

    @Override // com.baidu.tieba.r4a
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                return richTextEditor.getLastFocusEdit();
            }
            return null;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null && !richTextEditor.v()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q4a
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) && writeData.getWriteImagesInfo() != null) {
            this.v.r(writeData.getWriteImagesInfo());
            RichTextEditor richTextEditor = this.t;
            if (richTextEditor != null) {
                richTextEditor.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.t.t(writeData.getRichContentData());
            }
            WriteData writeData2 = this.e;
            if (writeData2 != null) {
                writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.e.setRichContentData(writeData.getRichContentData());
            }
        }
    }

    public final void e0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, str) == null) && str != null && this.b != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (chosedFiles != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    this.v.g().addChooseFile(imageFileInfo);
                    b0(imageFileInfo);
                }
            }
            this.b.x(new int[]{10, 34});
            this.b.i();
        }
    }

    @Override // com.baidu.tieba.t3a, com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public void j(@NonNull s4a s4aVar) {
        LinkedList<ImageFileInfo> chosedFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, s4aVar) == null) {
            super.j(s4aVar);
            m4a m4aVar = this.u;
            if (m4aVar != null) {
                m4aVar.l(this);
            }
            WriteImagesInfo g = this.v.g();
            if (g.size() > 0 && (chosedFiles = g.getChosedFiles()) != null) {
                for (ImageFileInfo imageFileInfo : chosedFiles) {
                    if (imageFileInfo != null) {
                        b0(imageFileInfo);
                    }
                }
                s4a s4aVar2 = this.b;
                if (s4aVar2 != null) {
                    s4aVar2.i();
                    this.b.x(new int[]{10, 34});
                }
            }
        }
    }

    public final void d0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && str != null && this.b != null && this.t != null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.parseJson(str);
            writeImagesInfo.updateQuality();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.getChosedFiles().size() > 0) {
                ImageFileInfo imageFileInfo = writeImagesInfo.getChosedFiles().get(0);
                int originalImgIndex = writeImagesInfo.getOriginalImgIndex();
                this.v.g().getChosedFiles().remove(originalImgIndex);
                this.v.g().getChosedFiles().add(originalImgIndex, imageFileInfo);
                this.t.q(imageFileInfo, writeImagesInfo.getOriginalImgViewIndex());
                this.b.x(new int[]{10, 34});
            }
        }
    }

    @Override // com.baidu.tieba.t3a, com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            this.v.h(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.t3a, com.baidu.tieba.l4a, com.baidu.tieba.q4a
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048599, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.v.m(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.q4a
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d050c, viewGroup, false);
            this.c = inflate;
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091bc8);
            this.h = (TbAlphaVideo) this.c.findViewById(R.id.obfuscated_res_0x7f09014e);
            RichTextEditor richTextEditor = (RichTextEditor) this.c.findViewById(R.id.obfuscated_res_0x7f091db8);
            this.t = richTextEditor;
            richTextEditor.setWriteImagesInfo(this.v.g());
            this.t.setOutImageOperateListener(this.w);
            this.t.setOnSpanGroupChangedListener(this.p);
            this.t.setEditOnClickListener(this.o);
            this.t.setEditOnFocusChangeListener(this.s);
            this.t.setBigEmotionSpanHandler(this.q);
            this.t.l(this.r);
            this.t.setRichTextLengthListener(new b(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                this.t.setForumId(gg.g(writeData.getForumId(), 0L));
            }
            this.t.o();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
